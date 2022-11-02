package com.xinsheng.o2o.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;

import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddmmss");
	private static final Random r = new Random();
	public static String generateThumbnail(CommonsMultipartFile thumbnail,String targetAddr) {
		String realFileName = getRandomFileName();//采用随机文件名
		String extension = getFileExtension(thumbnail);//获取扩展名png  gif  jpg  参数是thumbnail文件流
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath()+relativeAddr);
		try {
			Thumbnails.of(thumbnail.getInputStream())
			.size(460, 460)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/watermark.png")),0.25f)//0.25f水印透明度
			.outputQuality(0.8f)//压缩图片 
			.toFile(dest);
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
		
		return targetAddr;	
	}
	
	/*
	 * 
	 */
	private static void makeDirPath(String targetAddr) {
		// TODO Auto-generated method stub
		
	}


	/*
	 * 
	 */
	private static String getFileExtension(CommonsMultipartFile thumbnail) {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * 生成随机文件名，因为不能一样，采用年月日时分秒+五位随机数
	 */
	private static String getRandomFileName() {
		// TODO Auto-generated method stub
		return null;
	}



	public static void main(String[] args) throws IOException {
		
		Thumbnails.of(new File("E:\\ssm\\o2o\\src\\main\\resources\\study.jpg"))
		.size(460, 460)
		.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/watermark.png")),0.25f)//0.25f水印透明度
		.outputQuality(0.8f)//压缩图片 
		.toFile("E:\\ssm\\o2o\\src\\main\\resources\\studynew3.jpg");
		
	}
	
}
