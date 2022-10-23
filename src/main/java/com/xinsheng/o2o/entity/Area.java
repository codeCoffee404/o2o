package com.xinsheng.o2o.entity;

import java.util.Date;

public class Area {
//使用Integer Date 引用类型，而不是int基础类型原因：基础类型会赋空值为默认值
	private Integer areaId;
	private Integer priority;//权重
	private String areaName;//区域名称
	private Date createTime;//创建时间    这里建立数据库字段时，是datatime类型，因为其范围广；timestamp范围是1970-2037年，但会自动适配本机的时区
	private Date lastEditTime;//更新时间
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	
}
