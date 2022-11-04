package com.xinsheng.o2o.util;

public class PathUtil {
	private static String seperator =System.getProperty("file.separator");//获取系统的分隔符。。Linux  win
	/*
	 * 	file.separator 文件分隔符(在 UNIX 系统中是"/") 
		path.separator 路径分隔符(在 UNIX 系统中是":") 
		line.separator 行分隔符(在 UNIX 系统中是"/n") 
	 */
	public static  String getImgBasePath() {
		String os = System.getProperty("os.name");//获取系统的名称
		String basePath = "";
		if(os.toLowerCase().startsWith("win")) {
			basePath = "F:/o2oimage/image/";	
		}
		else {
			basePath = "/home/usr/image/";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	 
		public static String getShopImagePath(long shopId) {//将各自店铺的店铺图片存放在各自的文件夹下，用shop_id区别
			
			String imagePath = "upload/item/shop/" + shopId +  "/";
			return imagePath.replace("/", seperator);//反斜杠也用系统的来替换
			
		}
	
}
