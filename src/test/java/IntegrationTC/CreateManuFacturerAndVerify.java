package IntegrationTC;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateManuFacturerAndVerify {

	public static void main(String[] args) throws IOException {
		
		//Read from Property File
		FileInputStream fis=new FileInputStream("C:\\Users\\Dell\\Desktop\\commonData1.properties");
		Properties pdata=new Properties();
		pdata.load(fis);
		String AUSERNAME = pdata.getProperty("ausername");
		//String MUSERNAME = pdata.getProperty("musername");
		//String RUSERNAME = pdata.getProperty("rusername");
		String URL = pdata.getProperty("url");
		String PASSWORD = pdata.getProperty("password");
		
		//Read From Excel
		/*FileInputStream fis2=new FileInputStream(".\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("SCM_DATA");
		Row rw = sh.getRow(1);
		Cell ce1 = rw.getCell(1);
		Cell ce2 = rw.getCell(2);
		Cell ce3 = rw.getCell(3);
		Cell ce4 = rw.getCell(4);
		
		String MAN_UNAME = ce1.getStringCellValue();
		String MAN_PWD = ce2.getStringCellValue();
		String MAN_EMAIL = ce3.getStringCellValue();
		String MAN_PH_NO = ce4.getStringCellValue();*/
		
		
		//Launch Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		//Login as Admin
		driver.findElement(By.id("login:username")).sendKeys(AUSERNAME);
		driver.findElement(By.id("login:password")).sendKeys(PASSWORD);
		WebElement ele = driver.findElement(By.id("login:type"));
		ele.click();
		Select s=new Select(ele);
		s.selectByVisibleText("Admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Click on Add Manufacturer
		driver.findElement(By.linkText("Add Manufacturer")).click();
		
		//Enter Valid Data
		driver.findElement(By.id("manufacturer:name")).sendKeys("Alex");
		driver.findElement(By.id("manufacturer:email")).sendKeys("bake@king.com");
		driver.findElement(By.id("manufacturer:phone")).sendKeys("7698484848");
		driver.findElement(By.id("manufacturer:username")).sendKeys("BakeKING");
		driver.findElement(By.id("manufacturer:password")).sendKeys("goodbakers");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Alert a2 = driver.switchTo().alert();
		a2.accept();
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		
		//Login as Manufacturer with provided credentials
		driver.findElement(By.id("login:username")).sendKeys("BakeKING");
		driver.findElement(By.id("login:password")).sendKeys("goodbakers");
		WebElement ele2 = driver.findElement(By.id("login:type"));
		ele2.click();
		Select s2=new Select(ele2);
		s2.selectByVisibleText("Manufacturer");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement OWNER = driver.findElement(By.xpath("//tbody/tr/td[2]/section/article/table/tbody/tr[2]/td"));
		
		String NAME = OWNER.getText();
		if (NAME.contains("Alex")) {
			System.out.println("Manufacturer Name:"+NAME+".Test pass");
		}
		else {
			System.out.println("Test fail");

		}
	
		driver.close();	
		
		
	}

}
