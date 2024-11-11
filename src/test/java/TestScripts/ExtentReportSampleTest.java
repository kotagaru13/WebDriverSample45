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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSampleTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkReport.html");
		extentReports.attachReporter(spark);
		
	}
	
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
  @Test
  public void appiumSearchTest() {
	  extentTest = extentReports.createTest("Appium Search Test");
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Appium Tutorial");
	  searchBox.submit();
	  Assert.assertEquals("Appium Tutorial - Google Search",  driver.getTitle());
	  
  									}
  @Test
  public void cucumberSearchTest() {
	  extentTest = extentReports.createTest("Cucember Search Test");
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Cucumber Tutorial");
	  searchBox.submit();
	  Assert.assertEquals("Cucumber Tutorial - Google Search",  driver.getTitle());
	  
      						}
  
  
  
   @AfterTest
   public void finishExtent() {
	   extentReports.flush();
        }
   @AfterMethod
   public void teardown() {
	   driver.close();
   }
   
   
}
