package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Lib implements IAutoConstant {
	public static Workbook wb;
	public static String getCellValue(String sheetName,int rowNum,int colnum) {
		String cellValue="";
		try {
			wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			cellValue= wb.getSheet(sheetName).getRow(rowNum).getCell(colnum).toString();
		} catch (Exception e) {
		} 
	return cellValue;
	}
	
	public static String getPropertyValue(String propertyName) {
		String propertyvalue="";
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_FILE_PATH));
			propertyvalue=prop.getProperty(propertyName);
		} catch (Exception e) {
		} 
		return propertyvalue;
	}
	public static int getTotalRowCount(String sheetName) {
		int rowCount=0;
		try {
			wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			rowCount=wb.getSheet(sheetName).getLastRowNum();
		} 
		catch (Exception e) {
		} 
		return rowCount;
	}
	public static void CaptureScreenshots(WebDriver driver,String testmethodName) {
		
		try {
			String currentDateandTime=new Date().toString().replaceAll(":","_");
			TakesScreenshot ts=(TakesScreenshot)driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			File destFile=new File(SCREENSHOT_PATH+testmethodName+"_"+currentDateandTime+".png");
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
		}
		
	}

	}


