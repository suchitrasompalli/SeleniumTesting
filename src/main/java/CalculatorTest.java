import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalculatorTest {
	
	 /* 
     * Test typing input and displaying result.
     */
	public static void testDisplayValue(WebDriver driver) {
		// Enter value 10 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("10");
	      
	      try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      // Get the text box from the application
	      String result = driver.findElement(By.id("cpar1")).getAttribute("value");
	      
	      // Print a Log In message to the screen
	      System.out.println(" The Result is " + result);
	}
	
	 public static void main(String[] args) throws InterruptedException {
		 
		 // This time load properties from a properties file.
		 ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		 InputStream input = classLoader.getResourceAsStream("properties.txt");
		 // ...
		 Properties properties = new Properties();
		 try {
			properties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  System.setProperty(properties.getProperty("firefox_key"), properties.getProperty("firefox_driver_path"));
	      WebDriver driver = new FirefoxDriver();
	      // Puts a Implicit wait, Will wait for 10 seconds before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      // Launch website
	      driver.navigate().to("http://www.calculator.net/percent-calculator.html");
	      
	      // Maximize the browser
	      driver.manage().window().maximize();
	      testDisplayValue(driver);
	      
	      
	      // Close the Browser.
	      driver.close();
	   }

}
