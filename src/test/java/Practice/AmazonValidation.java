package Practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.WebDriverHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonValidation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Wildcraft Work Packs");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String ele = driver.findElement(By.xpath("(//span[text()='Deal of the Day'])[1]")).getText();
		System.out.println(ele);
		if (ele.contains("Deal of the Day")) {
			System.out.println("Test Pass");
			
		}
		else {
			System.out.println("Fail");

		}
	}

}
