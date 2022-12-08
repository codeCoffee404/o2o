package com.xinsheng.o2o.service.impl;


import java.io.InputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xinsheng.o2o.dao.ShopDao;
import com.xinsheng.o2o.dto.ShopExecution;
import com.xinsheng.o2o.entity.Shop;
import com.xinsheng.o2o.enums.ShopStateEnum;
import com.xinsheng.o2o.exceptions.ShopOperationException;
import com.xinsheng.o2o.service.ShopService;
import com.xinsheng.o2o.util.ImageUtil;
import com.xinsheng.o2o.util.PathUtil;


//��һ�����ʵ��service��δʵ�ֵķ���
@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDao shopDao;
	
	@Transactional
	public ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopOperationException {
		if(shop == null) {//���������ϢΪ�գ��򷵻�ö�����͵�null_shop
			return new ShopExecution(ShopStateEnum.NULL_SHOP);	
		}
		
		try {//��ʼ��һЩ������Ϣ��Ҫ�Ĳ���,���治�ܸı��ֵ
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//��ӵ�����Ϣ
			int effectedNum = shopDao.insertShop(shop);
			if(effectedNum <= 0) {
				throw new ShopOperationException("���̴���ʧ��");
			}else {
				if(shopImgInputStream!=null) {
					//�洢ͼƬ,����shopʵ������shopImgͼƬ
					try {
						addShopImg(shop, shopImgInputStream,fileName);
					}catch(Exception e) {
						throw new ShopOperationException("addShopImg error:" + e.getMessage());
					}
					//���µ��̵�ͼƬ��ַ
					effectedNum = shopDao.updateShop(shop);
					if(effectedNum<=0) {
						throw new ShopOperationException("����ͼƬ��ַʧ��");
					}
				    
					
				}
				
			}
			
		}catch(Exception e) {
			throw new ShopOperationException("addShop error:" + e.getMessage());
	
		}
		
		
		return new ShopExecution(ShopStateEnum.CHECK,shop);//
	}

//	private void addShopImg(Shop shop, File shopImg) {
//		// TODO Auto-generated method stub
//		
//	}

	private void addShopImg(Shop shop, InputStream shopImgInputStream ,String fileName) {
		//��ȡshopͼƬĿ¼�����ֵ·��
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName,dest);
		shop.setShopImg(shopImgAddr);
		
	}

	@Override
	public Shop getByShopId(long shopId) {
		
		return shopDao.queryByShopId(shopId);
	}

	@Override
	public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName)
			throws ShopOperationException {
		if (shop ==null||shop.getShopId()==null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		} else {
			//1.�ж��Ƿ���Ҫ����ͼƬ
			try {
			if (shopImgInputStream!=null&&fileName!=null&&!"".equals(fileName)) {
				Shop tempShop = shopDao.queryByShopId(shop.getShopId());
				if (tempShop.getShopImg()!=null) {
					ImageUtil.deleteFileOrPath(tempShop.getShopImg());
				}
				addShopImg(shop, shopImgInputStream, fileName);
			}
			//2.���µ�����Ϣ
			shop.setLastEditTime(new Date());
			int effectedNum = shopDao.updateShop(shop);
			if (effectedNum<=0) {
				return new ShopExecution(ShopStateEnum.INNER_ERROR);
			} else {
				shop = shopDao.queryByShopId(shop.getShopId());
				return new ShopExecution(ShopStateEnum.SUCCESS,shop);
			}}catch(Exception e) {
				throw new ShopOperationException("modifyShop error:"+e.getMessage());
			}
			
			
		}
		
		
	}
	
	
	
	
}
