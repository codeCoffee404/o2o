package com.xinsheng.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="shopadmin" ,method= {RequestMethod.GET})
public class ShopAdminController {

	@RequestMapping(value="/shopoperation")
	public String shopOperation() {
		
		return "shop/shopoperation";
		/*
		 * Ϊʲô����"shop/shopoperation"
		 * ��Ϊ��spring-web�ļ��ж�������ͼ������Ϊ
		 * property name="prefix" value="/WEB-INF/html/"></property>���Բ��ô�/html
		 * <property name="suffix" value=".html"></property>����Բ��ô�.html��׺
		 * ֱ��Ϊshopoperation
		 * 
		 */
	}
}
