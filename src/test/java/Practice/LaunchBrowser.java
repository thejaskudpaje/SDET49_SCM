package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

public class LaunchBrowser {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis2=new FileInputStream(".\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("SCM_DATA");
		Row rw = sh.getRow(1);
		Cell ce1 = rw.getCell(1);
		
		
		String MAN_UNAME = ce1.getStringCellValue();
		
		
		System.out.println(MAN_UNAME);
		
			
	}

}
