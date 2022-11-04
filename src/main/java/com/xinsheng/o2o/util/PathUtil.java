package com.xinsheng.o2o.util;

public class PathUtil {
	private static String seperator =System.getProperty("file.separator");//��ȡϵͳ�ķָ�������Linux  win
	/*
	 * 	file.separator �ļ��ָ���(�� UNIX ϵͳ����"/") 
		path.separator ·���ָ���(�� UNIX ϵͳ����":") 
		line.separator �зָ���(�� UNIX ϵͳ����"/n") 
	 */
	public static  String getImgBasePath() {
		String os = System.getProperty("os.name");//��ȡϵͳ������
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
	 
		public static String getShopImagePath(long shopId) {//�����Ե��̵ĵ���ͼƬ����ڸ��Ե��ļ����£���shop_id����
			
			String imagePath = "upload/item/shop/" + shopId +  "/";
			return imagePath.replace("/", seperator);//��б��Ҳ��ϵͳ�����滻
			
		}
	
}
