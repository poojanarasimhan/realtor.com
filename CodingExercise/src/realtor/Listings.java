package realtor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Listings extends Utils {
	private static WebElement element = null;
	 
	 public static WebElement numberOfHouse(WebDriver driver){
	 
	    element = driver.findElement(getId("srp-sort-count-wrap")).findElement(getTagName("span"));
	 
	    return element;
	 
	    }
	 
	 public static WebElement expPrice(WebDriver driver){
	 
	    element = driver.findElement(getId("2")).findElement(getCSS("[class='srp-item-price']"));
	 
	 return element;
	 
	    }
	 public static WebElement addressURL(WebDriver driver){
		 
		    element =driver.findElement(getId("2")).findElement(getCSS("[class='srp-item-address ellipsis']")).findElement(getTagName("a"));
		 
		 return element;
		 
		    }

}
