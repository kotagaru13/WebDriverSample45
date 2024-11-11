package TestScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GooglePageSearchTest {
	private static final boolean ture = false;
	WebDriver driver;
	
	@BeforeMethod
//	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
	}
	
//  @Test(priority=1)
	@Test(alwaysRun = true, dependsOnMethods = "SeleniumSearchTest")
  public void javaSearchTest() {
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Java Tutorial");
	  searchBox.submit();
	  Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());
	  
  }
  
//  @Test(enabled = false)
  
//   @Test(priority=2)
   @Test
    public void SeleniumSearchTest() {
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Selenium Tutorial");
	  searchBox.submit();
	  Assert.assertEquals("Selenium Tutorial - Google Search Page",  driver.getTitle());
	  
       }
   
   @Test(enabled = false)
//   @Test(priority=3)
      public void cucumberSearchTest() {
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Cucumber Tutorial");
	  searchBox.submit();
	  Assert.assertEquals("Cucumber Tutorial - Google Search",  driver.getTitle());
	  
      }
   
//   @Test(priority=4)
      public void appiumSearchTest() {
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Appium Tutorial");
	  searchBox.submit();
	  Assert.assertEquals("Appium Tutorial - Google Search",  driver.getTitle());
	  
      }
   
	 @AfterMethod
//     @AfterTest
	 public void tearDown() {
		 driver.close();
  
}
}
