package com.xinsheng.o2o.service;

import java.io.File;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xinsheng.o2o.dto.ShopExecution;
import com.xinsheng.o2o.entity.Shop;

public interface ShopService {
	ShopExecution addShop(Shop shop ,CommonsMultipartFile shopImg);



}
