import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2Example  {
	
	public static String firefox_key = "webdriver.gecko.driver";
	public static String firefox_driver_path = "C:\\Dev\\SeleniumGeckoDriver\\geckodriver.exe";
	
	public static String chrome_key = "webdriver.chrome.driver";
	public static String chrome_driver_path = "C:\\Dev\\SeleniumChromeDriver\\chromedriver.exe";
	
  public static void testFirefox() {
    	
    	System.setProperty(firefox_key, firefox_driver_path);
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        driver.quit();
    }
  
  	public static void testChrome() {
  		
  	  // Optional, if not specified, WebDriver will search your path for chromedriver.
  	  System.setProperty(chrome_key, chrome_driver_path);

  	  WebDriver driver = new ChromeDriver();
  	  driver.get("http://www.google.com/xhtml");
  	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  // Let the user actually see something!
  	  WebElement searchBox = driver.findElement(By.name("q"));
  	  searchBox.sendKeys("ChromeDriver");
  	  searchBox.submit();
  	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  // Let the user actually see something!
  	  driver.quit();

  		
  	}
  	
  public static void main(String[] args) {
	  Selenium2Example.testFirefox();
	  Selenium2Example.testChrome();
	  
  }
  
    
}