package com.xinsheng.o2o.service;

import java.io.File;

import com.xinsheng.o2o.dto.ShopExecution;
import com.xinsheng.o2o.entity.Shop;

public interface ShopService {
	ShopExecution addShop(Shop shop ,File shopImg);



}
