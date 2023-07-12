package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TreeStructure1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
		
		driver.findElement(By.id("login:username")).sendKeys("admin13");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		WebElement ele = driver.findElement(By.id("login:type"));
		ele.click();
		Select s=new Select(ele);
		s.selectByVisibleText("Retailer");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
	}

}
