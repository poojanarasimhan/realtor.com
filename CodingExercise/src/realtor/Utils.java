package realtor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class Utils {
	
	  WebDriverWait wait;
	
	 public void sendKeys(WebElement element, String value) {
		 
	        try {
	            element.sendKeys(value);
	        } catch (Exception e) {
	            throw new TestException(String.format("Error in sending value to the following element"));
	        }
	    }
	 
	 public void clearField(WebElement element) {
	        try {
	            element.clear();
	        } catch (Exception e) {
	            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
	        }
	    }
	 public void click(WebElement element) {
		
	        try {
	            element.click();
	        } catch (Exception e) {
	            throw new TestException(String.format("The following element is not clickable:"));
	        }
	    }

	    public void waitURL(WebDriver _driver ) {
	        try {
	            wait = new WebDriverWait(_driver, 50);
	           
	        } catch (Exception e) {
	            throw new TestException("The following element is not clickable: ");
	        }
	    }

	   public String removeLastChar(String str) {
	        return str.substring(0, str.length() - 1);
	    }

}
