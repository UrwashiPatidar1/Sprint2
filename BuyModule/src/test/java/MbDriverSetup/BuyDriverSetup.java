package MbDriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import MbPages.MbBuyPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyDriverSetup 
{
	 public static WebDriver driver;
	   public static ChromeOptions Coptions;
	   public static EdgeOptions Eoptions;
	 
	   public static WebDriver chromedriver() 
	   {
		   
		   WebDriverManager.chromedriver().setup();
		   Coptions= new ChromeOptions();
		   Coptions.addArguments("--start-maximized");
//		   Coptions.addArguments("incognito");
//    	   Coptions.addArguments("disable-notifications");
    	   Coptions.addArguments("disable-popup-blocking");
//	       Coptions.addArguments("--headless");
		   Coptions.addArguments("disable-blink-features-AutomationControlled");
		   driver= new ChromeDriver(Coptions);

		   driver.get("https://www.magicbricks.com/property-for-sale-rent-in-Mumbai/residential-real-estate-Mumbai");
		   return driver;
		   
	   }
	   public static WebDriver edgedriver() 
	   {
		   WebDriverManager.edgedriver().setup();
		   Eoptions= new EdgeOptions();
		   Eoptions.addArguments("--start-maximized");
//		   Eoptions.addArguments("incognito");
//		   Eoptions.addArguments("disable-notifications");
		   Eoptions.addArguments("disable-popup-blocking");
		//   Eoptions.addArguments("headless");
//		   Eoptions.addArguments("disable-blink-features-AutomationControlled");
		   driver= new EdgeDriver(Eoptions);
		   driver.get("https://www.magicbricks.com/property-for-sale-rent-in-Mumbai/residential-real-estate-Mumbai");
		   return driver;
		   
	   }
}
