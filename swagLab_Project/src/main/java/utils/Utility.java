package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class Utility 
{
	public static String fetchDataFromExcel(String sheet,int row,int column) throws EncryptedDocumentException, IOException 
	{
		String path="D:\\velocity java notes";
		FileInputStream file = new FileInputStream(path);
		String data = WorkbookFactory.create(file).getSheet("sheet1").getRow(1).getCell(1).getStringCellValue();
		return data;
	}
	
  public static void captureScreenshoot(WebDriver driver, int testId)
  {
	  
  }
}
