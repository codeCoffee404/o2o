package com.xinsheng.o2o.service.impl;

import java.io.File;
import java.nio.file.Path;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDao shopDao;
	
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) {
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
				if(shopImg!=null) {
					//�洢ͼƬ,����shopʵ������shopImgͼƬ
					try {
						addShopImg(shop, shopImg);
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

	private void addShopImg(Shop shop, File shopImg) {
		// TODO Auto-generated method stub
		
	}

	private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
		//��ȡshopͼƬĿ¼�����ֵ·��
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
		shop.setShopImg(shopImgAddr);
		
	}
	
	
	
	
}
