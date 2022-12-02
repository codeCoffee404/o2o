package com.xinsheng.o2o.dao;

import com.xinsheng.o2o.entity.Shop;

public interface ShopDao {

	/*
	 * ͨ��shopid��ѯ����
	 * @param shop
	 * @return shop
	 */
	Shop queryByShopId(long shopId);
	
	
	/*
	 * ��������
	 * @param shop
	 * @return 
	 */
	int insertShop(Shop shop);
	/*
	 * ���µ���
	 * @param shop
	 * @return 
	 */
	int updateShop(Shop shop);
	
}
