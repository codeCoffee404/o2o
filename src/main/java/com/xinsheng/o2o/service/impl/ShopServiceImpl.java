package com.xinsheng.o2o.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xinsheng.o2o.dao.ShopDao;
import com.xinsheng.o2o.dto.ShopExecution;
import com.xinsheng.o2o.entity.Shop;
import com.xinsheng.o2o.enums.ShopStateEnum;
import com.xinsheng.o2o.service.ShopService;
//��һ�����ʵ��service��δʵ�ֵķ���
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDao shopDao;
	
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, File shopImg) {
		if(shop == null) {//���������ϢΪ�գ��򷵻�ö�����͵�null_shop
			return new ShopExecution(ShopStateEnum.NULL_SHOP);	
		}
		
		try {//��ʼ��һЩ������Ϣ��Ҫ�Ĳ���
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//��ӵ�����Ϣ
			int effectedNum = shopDao.insertShop(shop);
			if(effectedNum <= 0) {
				throw new RuntimeException("���̴���ʧ��");
			}else {
				if(shopImg!=null) {
					//�洢ͼƬ,����shopʵ������shopImgͼƬ
					try {
						addShopImg(shop, shopImg);
					}catch(Exception e) {
						throw new RuntimeException("addShopImg error:" + e.getMessage());
					}
					//���µ��̵�ͼƬ��ַ
					effectedNum = shopDao.updateShop(shop);
					
					addShopImg(shop, shopImg);
					
				}
				
			}
			
		}catch(Exception e) {
			throw new RuntimeException("addShop error:" + e.getMessage());
			
		}
		
		
		return null;
	}
	
	
	
	
}
