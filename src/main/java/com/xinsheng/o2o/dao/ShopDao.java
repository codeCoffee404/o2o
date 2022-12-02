package com.xinsheng.o2o.dao;

import com.xinsheng.o2o.entity.Shop;

public interface ShopDao {

	/*
	 * 通过shopid查询店铺
	 * @param shop
	 * @return shop
	 */
	Shop queryByShopId(long shopId);
	
	
	/*
	 * 新增店铺
	 * @param shop
	 * @return 
	 */
	int insertShop(Shop shop);
	/*
	 * 更新店铺
	 * @param shop
	 * @return 
	 */
	int updateShop(Shop shop);
	
}
