package com.xinsheng.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinsheng.o2o.dao.AreaDao;
import com.xinsheng.o2o.entity.Area;
import com.xinsheng.o2o.service.AreaService;
@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaDao;//用Autowired作用，这里要用areaDao对象，请spring自动注入进来；因为service层依赖于dao层，所以定义对应dao
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return areaDao.queryArea();
	}

}
