package com.xinsheng.o2o.util;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {

	public static void main(String[] args) throws IOException {
		String basePath = Thread.currentThread().getContextClassLoader().getResource("")
	.getPath();
		Thumbnails.of(new File("E:\\ssm\\o2o\\src\\main\\resources\\study.jpg"))
		.size(200, 200)
		.watermark(Positions.TOP_RIGHT,ImageIO.read(new File(basePath+"/watermark.png")),0.25f)
		.outputQuality(0.8f)
		.toFile("E:\\ssm\\o2o\\src\\main\\resources\\studynew.jpg")
		
		
		
		;
		
	}
	
}
