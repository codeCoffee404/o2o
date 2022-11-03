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
import com.xinsheng.o2o.service.ShopService;
import com.xinsheng.o2o.util.ImageUtil;
import com.xinsheng.o2o.util.PathUtil;
//这一层就是实现service层未实现的方法
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDao shopDao;
	
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) {
		if(shop == null) {//如果店铺信息为空，则返回枚举类型的null_shop
			return new ShopExecution(ShopStateEnum.NULL_SHOP);	
		}
		
		try {//初始化一些店铺信息必要的参数
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//添加店铺信息
			int effectedNum = shopDao.insertShop(shop);
			if(effectedNum <= 0) {
				throw new RuntimeException("店铺创建失败");
			}else {
				if(shopImg!=null) {
					//存储图片,传入shop实体对象和shopImg图片
					try {
						addShopImg(shop, shopImg);
					}catch(Exception e) {
						throw new RuntimeException("addShopImg error:" + e.getMessage());
					}
					//更新店铺的图片地址
					effectedNum = shopDao.updateShop(shop);
					if(effectedNum<=0) {
						throw new RuntimeException("更新图片地址失败");
					}
				    
					
				}
				
			}
			
		}catch(Exception e) {
			throw new RuntimeException("addShop error:" + e.getMessage());
	
		}
		
		
		return new ShopExecution(ShopStateEnum.CHECK,shop);//
	}

	private void addShopImg(Shop shop, File shopImg) {
		// TODO Auto-generated method stub
		
	}

	private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
		//获取shop图片目录的相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
		shop.setShopImg(shopImgAddr);
		
	}
	
	
	
	
}
