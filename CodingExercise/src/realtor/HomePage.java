package realtor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Utils{
	 private static WebElement element = null;
	 
	 public static WebElement searchBox(WebDriver driver){
	 
	    element = driver.findElement( getId("searchBox"));
	    		//By.id("searchBox"));
	 
	    return element;
	 
	    }
	 
	 public static WebElement searchButton(WebDriver driver){
	 
	    element = driver.findElement(getCSS("[type='button'][class='btn btn-primary js-searchButton']"));
	 
	 return element;
	 
	    }
}
