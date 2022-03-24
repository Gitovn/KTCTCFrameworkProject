package com.uiFramework.KTCTC.helper.getScreenShot;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.uiFramework.KTCTC.helper.logger.LoggerHelper;
import com.uiFramework.KTCTC.helper.resource.ResourceHelper;

public class CaptureScreen {
	public static File reportDirectery= new File(ResourceHelper.getResourcePath("src/main/resources/screenShots"));
	private Logger log = LoggerHelper.getLogger(CaptureScreen.class);
	public String getScreenShot(String fileName, WebDriver driver){
		/*
		 * if(driver == null){ log.info("driver is null.."); return null; }
		 */
		if(fileName==""){
			fileName = "blank";
		}
	
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File screFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			destFile = new File(reportDirectery+"/"+fileName+"_"+formater.format(calendar.getTime())+".png");
			Files.copy(screFile.toPath(), destFile.toPath());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return destFile.toString();
	}
}
