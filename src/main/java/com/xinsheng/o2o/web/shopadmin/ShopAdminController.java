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
		 * 为什么返回"shop/shopoperation"
		 * 因为在spring-web文件中定义了视图解析器为
		 * property name="prefix" value="/WEB-INF/html/"></property>所以不用带/html
		 * <property name="suffix" value=".html"></property>则可以不用带.html后缀
		 * 直接为shopoperation
		 * 
		 */
	}
}
