package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadiochkBoxTest {
  @Test
  public void selectRadioTest() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/checkboxes");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
      boolean isSel = false;
	//	  boolean isSel = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).
	  if(isSel) {
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	  }
	  
	  
	  
	  
  }
}
