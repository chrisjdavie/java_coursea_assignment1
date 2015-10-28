
/**
 * Convert images to grayscale and save.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class batch_grayscale {
	//I started with the image I wanted (inImage)
	public ImageResource makeGray(ImageResource inImage) {
		//I made a blank image of the same size
		ImageResource outImage = new ImageResource(inImage);
		//for each pixel in outImage
		for (Pixel pixel: outImage.pixels()) {
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			//compute inPixel's red + inPixel's blue + inPixel's green
			//divide that sum by 3 (call it average)
			int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
			//set pixel's red to average
			pixel.setRed(average);
			//set pixel's green to average
			pixel.setGreen(average);
			//set pixel's blue to average
			pixel.setBlue(average);
		}
		//outImage is your answer
		return outImage;
	}

	public void selectAndConvertAndSave () {
		DirectoryResource dr = new DirectoryResource();
		for (File f: dr.selectedFiles()){
		    ImageResource inImage = new ImageResource(f);
		    ImageResource grayImage = makeGray(inImage);
		    String fname = inImage.getFileName();
		    fname = fname.substring(0, fname.length()-3);
		    fname += "jpg";
		    String newFname = "gray-" + fname;
		    grayImage.setFileName(newFname);
		    grayImage.save();
		  }
	}

	public void testGray() {
		ImageResource ir = new ImageResource();
		ImageResource gray = makeGray(ir);
		gray.draw();
	}
	
	
}