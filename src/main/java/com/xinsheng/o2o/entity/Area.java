package com.xinsheng.o2o.entity;

import java.util.Date;

public class Area {
//ʹ��Integer Date �������ͣ�������int��������ԭ�򣺻������ͻḳ��ֵΪĬ��ֵ
	private Integer areaId;
	private Integer priority;//Ȩ��
	private String areaName;//��������
	private Date createTime;//����ʱ��    ���ｨ�����ݿ��ֶ�ʱ����datatime���ͣ���Ϊ�䷶Χ�㣻timestamp��Χ��1970-2037�꣬�����Զ����䱾����ʱ��
	private Date lastEditTime;//����ʱ��
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
