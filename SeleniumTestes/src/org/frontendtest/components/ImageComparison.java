package org.frontendtest.components;

import java.io.*;
import java.util.HashMap;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import com.sun.image.codec.jpeg.*;

public class ImageComparison {
	private BufferedImage imgOut = null;
	private int pixelPerBlockX;
	private int pixelPerBlockY;
	private double threshold;

	public ImageComparison(int pixelPerBlockX, int pixelPerBlockY, double threshold) {
		this.pixelPerBlockX = pixelPerBlockX;
		this.pixelPerBlockY = pixelPerBlockY ;
		this.threshold = threshold;
	}
	public boolean fuzzyEqual(String path1, String path2, String pathOut) throws IOException {
		return fuzzyEqual(ImageIO.read(new File(path1)), ImageIO.read(new File(path2)), pathOut);
	}

	public boolean fuzzyEqual(File file1, File file2, String pathOut) throws IOException {
		return fuzzyEqual(ImageIO.read(file1), ImageIO.read(file2), pathOut);
	}
	
	public boolean fuzzyEqual(Image img1, Image img2, String pathOut) throws IOException {
		return fuzzyEqual(imageToBufferedImage(img1), imageToBufferedImage(img2), pathOut);
	}

	public boolean fuzzyEqual(BufferedImage img1, BufferedImage img2, String pathOut) throws IOException {
		boolean fuzzyEqual = true;
		img2 = adaptImageSize(img1,img2);

		imgOut = imageToBufferedImage(img2);
		Graphics2D outImgGraphics = imgOut.createGraphics();
		outImgGraphics.setColor(Color.RED);
		
		int subImageHeight;
		int subImageWidth;
//		String debug;

		int blocksx = (int) Math.ceil((float) img1.getWidth()
				/ (float) pixelPerBlockX);
		int blocksy = (int) Math.ceil((float) img1.getHeight()
				/ (float) pixelPerBlockY);

		for (int y = 0; y < blocksy; y++) {
//			debug = "";
			for (int x = 0; x < blocksx; x++) {
				subImageWidth=calcPixSpan(pixelPerBlockX,x,img1.getWidth());
				subImageHeight=calcPixSpan(pixelPerBlockY,y,img1.getHeight());
				//System.out.println(" Real Width:" +img1.getWidth() + " Real Height:" +img1.getHeight() + " X-Start:"+ x * pixelPerBlockX + " Y-Start:" +y * pixelPerBlockY + " sub width:" +subImageWidth + " sub height:" + subImageHeight);
				//System.out.println(" Real Width:" +img2.getWidth() + " Real Height:" +img2.getHeight() + " X-Start:"+ x * pixelPerBlockX + " Y-Start:" +y * pixelPerBlockY + " sub width:" +subImageWidth + " sub height:" + subImageHeight);
				HashMap<String, Integer> avgRgb1 = getAverageRgb(img1
						.getSubimage(x * pixelPerBlockX, y * pixelPerBlockY,
								subImageWidth, subImageHeight));
				HashMap<String, Integer> avgRgb2 = getAverageRgb(img2
						.getSubimage(x * pixelPerBlockX, y * pixelPerBlockY,
								subImageWidth, subImageHeight));
//				debug = debug
//						+ String.format(Locale.ENGLISH, "%1.2f",
//								calculateRgbDiff(avgRgb1, avgRgb2)) + " | ";
				if (calculateRgbDiff(avgRgb1, avgRgb2) > threshold) {
					outImgGraphics.drawRect(x * pixelPerBlockX, y * pixelPerBlockY,
							pixelPerBlockX - 1, pixelPerBlockY - 1);
					fuzzyEqual = false;
				}
			}
			//System.out.println(debug);
		}
		if(pathOut != null && !pathOut.isEmpty())
			saveImage(imgOut,pathOut);
		return fuzzyEqual;
	}

	private int calcPixSpan(int pixelPerBlock, int n, int overallSpan) {
		if (pixelPerBlock * (n + 1) > overallSpan)
			return overallSpan % pixelPerBlock;
		else
			return pixelPerBlock;
	}
	
	private BufferedImage adaptImageSize(BufferedImage img1, BufferedImage img2) throws IOException {
		int scalePixelWidth;
		int scalePixelHeight;		
		//System.out.println("1 Real Width:" +img1.getWidth() + " Real Height:" +img1.getHeight());
		//System.out.println("2 Real Width:" +img2.getWidth() + " Real Height:" +img2.getHeight());

		if(((float)img2.getWidth()/(float)img1.getWidth()) < ((float)img2.getHeight()/(float)img1.getHeight())){
			scalePixelWidth = img1.getWidth();
			scalePixelHeight = (int) (img2.getHeight() * Math.ceil((float)img1.getWidth()/(float)img2.getWidth()));
			//System.out.println("If : Scale Width:" +scalePixelWidth + " Scale Height:" +scalePixelHeight);
		}else {
			scalePixelHeight = img1.getHeight();
			scalePixelWidth = (int) (img2.getWidth() * Math.ceil((float)img1.getHeight()/(float)img2.getHeight()));
			//System.out.println("Else: Scale Width:" +scalePixelWidth + " Scale Height:" +scalePixelHeight);
		}
		//System.out.println("1 Real Width:" +img1.getWidth() + " Real Height:" +img1.getHeight());
		//System.out.println("2 Real Width:" +Thumbnails.of(img2).size(scalePixelWidth, scalePixelHeight).asBufferedImage().getWidth() + " Real Height:" +Thumbnails.of(img2).size(scalePixelWidth, scalePixelHeight).asBufferedImage().getHeight());

		return Thumbnails.of(img2).size(scalePixelWidth, scalePixelHeight).asBufferedImage();
	}
	private double calculateRgbDiff(HashMap<String, Integer> avgRgb1,
			HashMap<String, Integer> avgRgb2) {
		double maxDifference = 255 * 3;
		double difference = Math.abs(avgRgb1.get("r") - avgRgb2.get("r"))
				+ Math.abs(avgRgb1.get("g") - avgRgb2.get("g"))
				+ Math.abs(avgRgb1.get("b") - avgRgb2.get("b"));

		return difference / maxDifference;
	}


	private HashMap<String, Integer> getAverageRgb(BufferedImage img) {
		Raster currentRaster = img.getData();
		HashMap<String, Integer> averageRgb = new HashMap<String, Integer>();
		averageRgb.put("r", 0);
		averageRgb.put("g", 0);
		averageRgb.put("b", 0);

		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {
				averageRgb.put("r", averageRgb.get("r") + currentRaster.getSample(x, y, 0));
				averageRgb.put("g", averageRgb.get("g") + currentRaster.getSample(x, y, 1));
				averageRgb.put("b", averageRgb.get("b") + currentRaster.getSample(x, y, 2));

			}
		}

		averageRgb.put("r",
				averageRgb.get("r") / (img.getHeight() * img.getWidth()));
		averageRgb.put("g",
				averageRgb.get("g") / (img.getHeight() * img.getWidth()));
		averageRgb.put("b",
				averageRgb.get("b") / (img.getHeight() * img.getWidth()));

		return averageRgb;
	}

	private BufferedImage imageToBufferedImage(Image img) {
		BufferedImage bi = new BufferedImage(img.getWidth(null),
				img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = bi.createGraphics();
		g2.drawImage(img, null, null);
		return bi;
	}

	private void saveImage(Image img, String filename) {
		BufferedImage bi = imageToBufferedImage(img);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filename);
		} catch (java.io.FileNotFoundException io) {
			System.out.println("File Not Found");
		}
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bi);
		param.setQuality(0.8f, false);
		encoder.setJPEGEncodeParam(param);
		try {
			encoder.encode(bi);
			out.close();
		} catch (java.io.IOException io) {
			System.out.println("IOException");
		}
	}
	
	
}
