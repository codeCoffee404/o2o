package com.xinsheng.o2o.web.shopadmin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xinsheng.o2o.entity.Shop;
import com.xinsheng.o2o.util.HttpServletRequestUtil;
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
	@RequestMapping(value="/registershop",method=RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> registerShop(HttpServletRequest request){
		//������ע��ı���Ϣ����浽���request�����������map����������һЩ��Ҫ�ļ�ֵ��
		// ��Ϊ����������Map<String,Object>��ֵ�ԣ�Ȼ����@ResponseBodyע��ת��Ϊjson����
		
		//1.���ܲ�ת����Ӧ�Ĳ���������������Ϣ��ͼƬ��Ϣ
		Map<String,Object> modelMap=new HashMap<String,Object>();
		String shopStr = new HttpServletRequestUtil.getString(request,"shopStr");
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		
		//2.ע�����
		//3.���ؽ��,

		
	}
}
