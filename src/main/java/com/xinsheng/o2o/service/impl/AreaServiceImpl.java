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
	private AreaDao areaDao;//��Autowired���ã�����Ҫ��areaDao������spring�Զ�ע���������Ϊservice��������dao�㣬���Զ����Ӧdao
	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return areaDao.queryArea();
	}

}
