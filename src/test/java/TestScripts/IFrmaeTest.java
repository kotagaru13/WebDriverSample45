package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IFrmaeTest {
  @Test
  public void f() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://the-internet.herokuapp.com/iframe");
	  WebElement iFrameElem = driver.findElement(By.id("mce_0_ifr"));
	  driver.switchTo().frame(iFrameElem);
	  WebElement inputTxt = driver.findElement(By.id("tinymce"));
	  inputTxt.clear(); //Edit here
	 
	  inputTxt.sendKeys("Hello Welcome" );
	  
	  driver.switchTo().defaultContent();
	  WebElement linkTxt = driver.findElement(By.cssSelector("span.tox-statusbar__branding"));
	  linkTxt.click();
	  
	  
	  
  }
}
