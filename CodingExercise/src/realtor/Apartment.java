package realtor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Apartment extends Utils {
	private static WebElement element = null;
	 
	 public static WebElement actPrice(WebDriver driver){
	 
	    element = driver.findElement(getXPATH("//div[@itemtype='http://schema.org/Offer']/span[@itemprop='price']"));
	 
	    return element;
	 
	    }
	 
}
