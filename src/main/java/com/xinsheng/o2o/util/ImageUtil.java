package com.xinsheng.o2o.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		String realFileName = getRandomFileName();//��������ļ���
		String extension = getFileExtension(thumbnail);//��ȡ��չ��png  gif  jpg  ������thumbnail�ļ���
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath()+relativeAddr);
		try {
			Thumbnails.of(thumbnail.getInputStream())
			.size(460, 460)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/watermark.png")),0.25f)//0.25fˮӡ͸����
			.outputQuality(0.8f)//ѹ��ͼƬ 
			.toFile(dest);
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
		
		return targetAddr;	
	}
	
	/*
	 *  ����Ŀ��·�����漰����Ŀ¼����/home/xxxx/image/xxx,jpg
	 *  ��ôhome  xxxx  image�������ļ��ж����Զ�����  
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		
	}


	/*
	 * ��ȡ�����ļ�����չ��
	 */
	private static String getFileExtension(CommonsMultipartFile cFile) {
		String originalFileName= cFile.getOriginalFilename();
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}


	/*
	 * ��������ļ�������Ϊ����һ��������������ʱ����+��λ�����
	 */
	private static String getRandomFileName() {
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
			return nowTimeStr+rannum;
	}



	public static void main(String[] args) throws IOException {
		
		Thumbnails.of(new File("E:\\ssm\\o2o\\src\\main\\resources\\study.jpg"))
		.size(460, 460)
		.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/watermark.png")),0.25f)//0.25fˮӡ͸����
		.outputQuality(0.8f)//ѹ��ͼƬ 
		.toFile("E:\\ssm\\o2o\\src\\main\\resources\\studynew3.jpg");
		
	}
	
}