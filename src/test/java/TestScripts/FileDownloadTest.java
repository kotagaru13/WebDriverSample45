package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FileDownloadTest {
  @Test
  public void fileDownloadTC() throws InterruptedException {
	  ChromeOptions options = new ChromeOptions();
	  
	  WebDriver driver = new ChromeDriver(options);
	  
	  driver.manage().window().maximize();
	  driver.get("https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/");
	  Thread.sleep(2000);
	  WebElement btnDownload = driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']"));
	  
	  btnDownload.click();
		  
	  
  }
}
