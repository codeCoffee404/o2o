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
		//店铺在注册的表单信息都会存到这个request里，返回类型是map，用来返回一些必要的键值对
		// 因为返回类型是Map<String,Object>键值对，然后用@ResponseBody注解转化为json对象
		
		//1.接受并转换响应的参数，包括店铺信息及图片信息
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
			modelMap.put("errMsg", "上传图片不能为空");
			return modelMap;
		}
		try {
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}
		
	
		
		//2.注册店铺
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
			modelMap.put("errMsg", "请输入店铺信息");
			return modelMap;
		}
		
		
		
		
		
		//3.返回结果,


	
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
			throw new RuntimeException("调用inputStreamtoFile产生异常"+e.getMessage());
		}finally{
			try {
				if (os!=null) {
					os.close();
				}
				if (ins!=null) {
					ins.close();
				}
				
			} catch (Exception e) {
				throw new RuntimeException("调用inputStreamtoFile关闭io产生异常"+e.getMessage());
			}
		}
		
		
		
		
		
	}
	
	
}
