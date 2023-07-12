package SystemTestCasesAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderingAndVerifying {

	public static void main(String[] args) throws InterruptedException {
		//Launch Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
		
		//Login as Retailer
		driver.findElement(By.id("login:username")).sendKeys("admin13");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		WebElement ele = driver.findElement(By.id("login:type"));
		ele.click();
		Select s=new Select(ele);
		s.selectByVisibleText("Retailer");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Click on New Order
		driver.findElement(By.linkText("New Order")).click();
		driver.findElement(By.id("8")).sendKeys("100");
		WebElement price = driver.findElement(By.id("totalPrice32"));
		String val1 = price.getText();
		//Click on Post Order
		driver.findElement(By.id("btnSubmit")).click();
		
		//Click on My orders
		driver.findElement(By.id("My Orders")).click();
		
		//Logout as Retailer
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		
		//Login as Admin
		driver.findElement(By.id("login:username")).sendKeys("admin");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		WebElement ele5 = driver.findElement(By.id("login:type"));
		ele5.click();
		Select s5=new Select(ele5);
		s5.selectByVisibleText("Admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Products")).click();
		
		//Click on Orders
		driver.findElement(By.linkText("Orders")).click();
		
		//Logout as admin
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		
		//Login as Manufacturer
		driver.findElement(By.id("login:username")).sendKeys("admin12");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		WebElement ele4 = driver.findElement(By.id("login:type"));
		ele4.click();
		Select s4=new Select(ele4);
		s4.selectByVisibleText("Manufacturer");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Click on Orders
		driver.
		
		
		
	}

}
