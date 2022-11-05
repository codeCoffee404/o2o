package com.xinsheng.o2o.service;



import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xinsheng.o2o.dto.ShopExecution;
import com.xinsheng.o2o.entity.Shop;

public interface ShopService {
	ShopExecution addShop(Shop shop ,CommonsMultipartFile shopImg) throws RuntimeException ;

	



}
