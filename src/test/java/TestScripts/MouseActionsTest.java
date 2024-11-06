package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsTest {
	public void mouseActionTest() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--blink-settings=imagesEnables=fasle");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		 driver.get("https:demo.opencart.com/");
	Thread.sleep(2000);
	WebElement srcBox = driver.findElement(By.name("search"));
	
	WebElement menu =driver.findElement(By.xpath("ul[@class='nav navbar-nav']//descendant::a[text()='Components']"));
	actions.moveToElement(menu).perform();
	
	
		
	

	  
  }
}
