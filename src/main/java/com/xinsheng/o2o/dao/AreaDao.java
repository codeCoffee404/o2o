package com.xinsheng.o2o.dao;
import  com.xinsheng.o2o.entity.Area;
import java.util.List;

import com.xinsheng.o2o.entity.Area;

public interface AreaDao {

	/*
	 * 列出区域列表
	 * @return areaList
	 */
	List<Area> queryArea();
}
