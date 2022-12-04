package com.xinsheng.o2o.service;

import java.io.InputStream;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xinsheng.o2o.dto.ShopExecution;
import com.xinsheng.o2o.entity.Shop;
import com.xinsheng.o2o.exceptions.ShopOperationException;

public interface ShopService {
	
	Shop getByShopId(long shopId);
	
	ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopOperationException;
	
	static ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopOperationException {
		return null;
	}

}
