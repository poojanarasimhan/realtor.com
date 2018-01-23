package realtor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class Utils {


	public static By getCSS(String Selector) {
		By value = null;
		try {
			value = By.cssSelector(Selector);
		} catch (Exception e) {

			throw new TestException(String.format("Cannot locate element via css id or class selector" + Selector));
		}
		return value;

	}

	public static By getXPATH(String Selector) {
		By value = null;
		try {
			value = By.xpath(Selector);

		} catch (Exception e) {

			throw new TestException(String.format("Cannot find the css selector" + Selector));
		}
		return value;
	}

	public static By getTagName(String Selector) {
		By value = null;
		try {
			value = By.tagName(Selector);

		} catch (Exception e) {

			throw new TestException(String.format("Cannot find the tag name" + Selector));
		}
		return value;
	}

	public static By getId(String Selector) {
		By value = null;
		try {
			value = By.id(Selector);

		} catch (Exception e) {

			throw new TestException(String.format("Cannot find the id" + Selector));
		}
		return value;
	}

	public void sendKeys(WebElement element, String value) {

		try {
			element.sendKeys(value);
		} catch (Exception e) {
			throw new TestException(
					String.format("Error in sending value to the following element :" + element.getText()));
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
			throw new TestException(String.format("The following element is not clickable:" + element.getText()));
		}
	}

	public void waitURL(WebDriver _driver, String title) {
		try {
	
			 new WebDriverWait(_driver, 50).until(ExpectedConditions.titleIs(title));

		} catch (Exception e) {
			throw new TestException("Error occured while navigation to the next page ");
		}
	}

	public String removeLastChar(String str) {
		return str.substring(0, str.length() - 1);
	}

}
