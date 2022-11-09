package com.xinsheng.o2o.web.shopadmin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sun.imageio.plugins.common.ImageUtil;
import com.xinsheng.o2o.dto.ShopExecution;
import com.xinsheng.o2o.entity.PersonInfo;
import com.xinsheng.o2o.entity.Shop;
import com.xinsheng.o2o.enums.ShopStateEnum;
import com.xinsheng.o2o.service.ShopService;
import com.xinsheng.o2o.util.HttpServletRequestUtil;
import com.xinsheng.o2o.util.PathUtil;
import com.xinsheng.o2o.util.ImageUtil;
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
	@Autowired
	private ShopService shopService;
	@RequestMapping(value="/registershop",method=RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> registerShop(HttpServletRequest request){
		//������ע��ı���Ϣ����浽���request�����������map����������һЩ��Ҫ�ļ�ֵ��
		// ��Ϊ����������Map<String,Object>��ֵ�ԣ�Ȼ����@ResponseBodyע��ת��Ϊjson����
		
		//1.���ܲ�ת����Ӧ�Ĳ���������������Ϣ��ͼƬ��Ϣ
		Map<String,Object> modelMap=new HashMap<String,Object>();
		String shopStr =  HttpServletRequestUtil.getString(request,"shopStr");
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (commonsMultipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartHttpServletRequest  = (MultipartHttpServletRequest) request;
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest
					.getFile("shopImg");
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "�ϴ�ͼƬ����Ϊ��");
			return modelMap;
		}
		try {
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}
		
	
		
		//2.ע�����
		if (shop != null&& shopImg != null) {
			PersonInfo owner =new PersonInfo();
			owner.setUserId(1L);
			shop.setOwner(owner);
			File shopImgFile = new File(PathUtil.getImgBasePath() + ImageUtil.getRandomFileName());
			
			try {
				shopImgFile.createNewFile();
			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
			try {
				inputStreamtoFile(shopImg.getInputStream(), shopImgFile);
			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
			
			ShopExecution se = ShopService.addShop(shop,shopImg);
			if (se.getState() == ShopStateEnum.CHECK.getState()) {
				modelMap.put("succcess", true);
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", se.getStateInfo());
			}
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "�����������Ϣ");
			return modelMap;
		}
		
		
		
		
		
		//3.���ؽ��,


	
	}
	private static void inputStreamtoFile(InputStream ins ,File file) {
		FileOutputStream os =null;
		try {
			os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer =new byte[1024];
			while ((bytesRead = ins.read(buffer))!=-1) {
				os.write(buffer,0,bytesRead);
				
			}
		} catch (Exception e) {
			throw new RuntimeException("����inputStreamtoFile�����쳣"+e.getMessage());
		}finally{
			try {
				if (os!=null) {
					os.close();
				}
				if (ins!=null) {
					ins.close();
				}
				
			} catch (Exception e) {
				throw new RuntimeException("����inputStreamtoFile�ر�io�����쳣"+e.getMessage());
			}
		}
		
		
		
		
		
	}
	
	
}
