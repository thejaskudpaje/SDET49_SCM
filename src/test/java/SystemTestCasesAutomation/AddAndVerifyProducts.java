package SystemTestCasesAutomation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddAndVerifyProducts {

	public void SystemT() {
		//Launch Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 		driver.get("http://rmgtestingserver/domain/Supply_Chain_Management/");
		
		//Login as Admin
		driver.findElement(By.id("login:username")).sendKeys("admin");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		WebElement ele = driver.findElement(By.id("login:type"));
		ele.click();
		Select s=new Select(ele);
		s.selectByVisibleText("Admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Click on Add Product
		driver.findElement(By.linkText("Add Products")).click();
		System.out.println(driver.getTitle());
		
		//Enter Valid Product Details
		driver.findElement(By.id("product:name")).sendKeys("Butter Cookies");
		driver.findElement(By.id("product:price")).sendKeys("10");
		WebElement ele2 = driver.findElement(By.id("product:unit"));
		ele2.click();
		Select s2=new Select(ele2);
		s2.selectByVisibleText("PCS");
		WebElement ele3 = driver.findElement(By.id("product:category"));
		ele3.click();
		Select s3=new Select(ele3);
		s3.selectByVisibleText("snacks");
		driver.findElement(By.name("rdbStock")).click();
		driver.findElement(By.id("product:description")).sendKeys("Make your Evening better with Cookie!");
		driver.findElement(By.xpath("//input[@value='Add Product']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Logout as Admin
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		
		//Login as Manufacturer
		driver.findElement(By.id("login:username")).sendKeys("admin12");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		WebElement ele4 = driver.findElement(By.id("login:type"));
		ele4.click();
		Select s4=new Select(ele4);
		s4.selectByVisibleText("Manufacturer");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Click on Products
		driver.findElement(By.linkText("Products")).click();
		
		//Click on Manage Stock
		driver.findElement(By.linkText("Manage Stock")).click();
		driver.findElement(By.name("txtQuantity[19]")).sendKeys("100");
		driver.findElement(By.id("btnSubmit")).click();
		Alert a2 = driver.switchTo().alert();
		a2.accept();
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		System.out.println("Stock has been updated");


		//Login as Admin
		driver.findElement(By.id("login:username")).sendKeys("admin");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		WebElement ele5 = driver.findElement(By.id("login:type"));
		ele5.click();
		Select s5=new Select(ele5);
		s5.selectByVisibleText("Admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Products")).click();
		System.out.println("Updated Product Quantity is visible");
		
		//Logout as Admin
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		
		driver.close();
		
		
		
		
		
		
		
		
		
	}

}
