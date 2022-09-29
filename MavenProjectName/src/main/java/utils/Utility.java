package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	static String s;
	static WebDriver driver;
	static DateTimeFormatter dateTime;
	private static POIFSFileSystem File;
	private static FileInputStream file;
	public static WebDriver takeScreenShot(WebDriver driver) throws IOException
	{
		dateTime= DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		s = dateTime.format(now);
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Mohan Padghan\\Pictures\\New folder"+s+".jpeg");
		FileHandler.copy(source, dest);
		return driver;
	}
   	public static String getDataFromExcel(String Sheet, int row, int column) throws IOException 
	{
		String path = "C:\\Users\\Mohan Padghan\\Desktop\\Test.xlsx";
				
	    FileInputStream file = new FileInputStream(path);
		
		String Data = WorkbookFactory.create(File).getSheet(Sheet).getRow(row).getCell(column).getStringCellValue();
		
		return Data;
	}
	
}
