package TestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import commonUtils.Utility;

public class LoginTest {
	 WebDriver driver;
	 Properties prop;
	 
	 @BeforeTest
	 public void readProperty() throws IOException 
	 { String path = System.getProperty("user.dir") +  "//src//test//resources//configFiles//config.properties";
	   FileInputStream fin = new FileInputStream(path);
	   prop = new Properties();
	   prop.load(fin);
	   
		 
	 }
	 
	 
	 @BeforeMethod
	 public void setup() {
		 String strBrowser = prop.getProperty("browser");
		 if(strBrowser.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		  } else if (strBrowser.equalsIgnoreCase("edge")) {
			  driver = new EdgeDriver();
	       }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 	}
	 
  @Test(dataProvider = "loginData")
  
  public void ValidloginTest( String strUser, String strPwd)
  {
 	driver.get(prop.getProperty("url"));
    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(strUser);
    driver.findElement(By.name("password")).sendKeys(strPwd);
    driver.findElement(By.cssSelector("button.radius")).click();
  }
    @DataProvider(name="loginData")
    public Object[][] getData() throws CsvValidationException, IOException
    {
    	String path = System.getProperty("user.dir") + "//src//test//resources//testData//loginData.csv";
    	CSVReader reader = null;
    	try {
    		reader = new CSVReader(new FileReader(path));
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    		
    	} String cols[];
    	  ArrayList<Object> dataList = new ArrayList<Object>();
    	  while ((cols = reader.readNext( )) !=null) {
    		  Object[] record = {cols[0], cols[1]};
    		  dataList.add(record);
    	
               }
    	  
    	  return dataList.toArray(new Object[dataList.size()] []);
    	  
      
    	}
}
