import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalculatorTest {
	
	 /* 
     * Test text-box interaction typing input and displaying result.
     */
	public static void textInputDisplay() {
		
		 WebDriver driver = new FirefoxDriver();
	      // Puts a Implicit wait, Will wait for 10 seconds before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	     
		 // Launch website
	      driver.navigate().to("http://www.calculator.net/percent-calculator.html");
	      
	      // Maximize the browser
	      driver.manage().window().maximize();
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
	      // Close the Browser.
	      driver.close();
	}
	
	 /* 
     * Test text-box interaction typing input and displaying result.
     */
	public static void radioButtontest() {
		  WebDriver driver = new FirefoxDriver();
	      
	      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      //Launch website
	      driver.navigate().to("http://www.calculator.net/mortgage-payoff-calculator.html");
	      driver.manage().window().maximize();
	      
	      // Click on Radio Button
	      driver.findElement(By.id("cpayoff1")).click();
	      System.out.println("The Output of the IsSelected " +
	         driver.findElement(By.id("cpayoff1")).isSelected());
	      System.out.println("The Output of the IsEnabled " +
	         driver.findElement(By.id("cpayoff1")).isEnabled());
	      System.out.println("The Output of the IsDisplayed " +
	         driver.findElement(By.id("cpayoff1")).isDisplayed());
	      
	      //Close the Browser.
	      driver.close();
	}
	
	public static void checkBoxSelection() {
		WebDriver driver = new FirefoxDriver();
	    //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Launch website
	    driver.navigate().to("http://www.calculator.net/mortgage-calculator.html");
	    driver.manage().window().maximize();
	    
	    //Click on check Box
	    driver.findElement(By.id("caddoptional")).click();
	    
	    System.out.println("The Output of the IsSelected " +
	       driver.findElement(By.id("caddoptional")).isSelected());      
	    System.out.println("The Output of the IsEnabled " +
	       driver.findElement(By.id("caddoptional")).isEnabled());
	    System.out.println("The Output of the IsDisplayed " +
	       driver.findElement(By.id("caddoptional")).isDisplayed());
	    
	    driver.close();
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
	      
	      textInputDisplay();
	      radioButtontest();
	      checkBoxSelection();
	     
	   }

}
