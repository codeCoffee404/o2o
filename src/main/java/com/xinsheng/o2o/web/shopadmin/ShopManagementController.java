package com.xinsheng.o2o.web.shopadmin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
	@RequestMapping(value="/registershop",method=RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> registerShop(HttpServletRequest request){
		//������ע��ı���Ϣ����浽���request�����������map����������һЩ��Ҫ�ļ�ֵ��
		// ��Ϊ����������Map<String,Object>��ֵ�ԣ�Ȼ����@ResponseBodyע��ת��Ϊjson����
		//1.���ܲ�ת����Ӧ�Ĳ���������������Ϣ��ͼƬ��Ϣ
		//2.ע�����
		//3.���ؽ��
		
		
	}
}
