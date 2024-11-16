package commonUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
   public static String getScreenshotPath(WebDriver driver) {
	  TakesScreenshot Screen = (TakesScreenshot)driver;
	  File src =Screen.getScreenshotAs(OutputType.FILE);
	  String srcFile = System.getProperty("user.dir")
			  + "/screenshots/"
			  + System.currentTimeMillis()

			  + ".png";
	File dest = new File(srcFile);
	  try {
		  FileUtils.copyFile(src, dest);

	  } catch (IOException e) {
		  e.printStackTrace();
	  }
	  return srcFile;
  }
	  
	  
	  
	  
  }
