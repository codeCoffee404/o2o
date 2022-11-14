package com.xinsheng.o2o.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xinsheng.o2o.BaseTest;
import com.xinsheng.o2o.dto.ShopExecution;
import com.xinsheng.o2o.entity.Area;
import com.xinsheng.o2o.entity.PersonInfo;
import com.xinsheng.o2o.entity.Shop;
import com.xinsheng.o2o.entity.ShopCategory;
import com.xinsheng.o2o.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	@Test
	public void testAddShop() throws FileNotFoundException {
		
		    Shop shop = new Shop();
			PersonInfo owner =new PersonInfo();
			Area area = new Area();
			//ShopCategory shopCategory = new ShopCategory();
			owner.setUserId(1L);
			area.setAreaId(2);
			ShopCategory sc = new ShopCategory();
			sc.setShopCategoryId(1L);
			//ShopCategory.setShopCategoryId(1L);
			shop.setOwner(owner);
			shop.setArea(area);
			shop.setShopName("mytestservice33");
			shop.setShopDesc("mytestservice33");
			shop.setShopAddr("testaddrservice33");
			shop.setPhone("138105service33");
			
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			shop.setEnableStatus(ShopStateEnum.CHECK.getState());
			shop.setAdvice("…Û∫À÷–");
			shop.setShopCategory(sc);
			File shopImg = new File("F:\\\\headgithub.png");
			InputStream is = new FileInputStream(shopImg);
			ShopExecution se = ShopService.addShop(shop,is,shopImg.getName());
		
	}
}































