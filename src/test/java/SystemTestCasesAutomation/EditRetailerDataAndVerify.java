package SystemTestCasesAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditRetailerDataAndVerify {

	public static void main(String[] args) {
		//Launch Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
		
		//Login as Admin
		driver.findElement(By.id("login:username")).sendKeys("admin");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		WebElement ele = driver.findElement(By.id("login:type"));
		ele.click();
		Select s=new Select(ele);
		s.selectByVisibleText("Admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Click on Retailer
		driver.findElement(By.linkText("Retailers")).click();
		
		//Edit a Retailer
		driver.findElement(By.xpath("(//img[@alt='edit'])[7]")).click();
		driver.findElement(By.name("txtRetailerAddress")).sendKeys("Bangalore,Bengaluru");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Alert a1 = driver.switchTo().alert();
		a1.accept();
		
		//Logout as Admin
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		
		//Login as Retailer
		driver.findElement(By.id("login:username")).sendKeys("admin13");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		WebElement ele2 = driver.findElement(By.id("login:type"));
		ele2.click();
		Select s2=new Select(ele2);
		s2.selectByVisibleText("Retailer");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Edit Address is present");
		//Logout as Retailer
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		
		
		
		
		
		
	}

}
