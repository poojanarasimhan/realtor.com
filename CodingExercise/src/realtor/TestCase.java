package realtor;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import realtor.Utils;

public class TestCase extends Utils {

	 WebDriver driver;

	/**
	 * This function will execute before each Test tag in testng.xml
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
	
		if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'Edge'
				else if(browser.equalsIgnoreCase("Edge")){
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
					//create Edge instance
					driver = new EdgeDriver();
				}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testPages() throws InterruptedException{
		//Navigate to realtor.com
		driver.get("http://realtor.com");
		
		//Enter �Morgantown, WV� into the search box.
		WebElement searchBox = HomePage.searchBox(driver);
		clearField(searchBox);
		sendKeys(searchBox,"Morgantown, WV");	
		
		
		//Hit Enter
		WebElement searchButton = HomePage.searchButton(driver);
		click(searchButton);
		String pageTitle = "Morgantown, WV Real Estate - Morgantown Homes for Sale - realtor.com�";
		waitURL(driver,pageTitle);
		
		//Verify that number N in �[N] Homes sorted by Relevant Listings� located above the
		//search results is greater than 0.
		String numberOfHouse =Listings.numberOfHouse(driver).getText();
		String[] numHouse = numberOfHouse.split(" ");
		Integer num = Integer.parseInt(numHouse[0]);
		assertTrue(num>0);
		
		
		String expPrice= Listings.expPrice(driver).getText();
		
		//Click on the Address of the second search result
		WebElement addressURL =  Listings.addressURL(driver) ;
		click(addressURL);
		
		String actPrice = Apartment.actPrice(driver).getText();
		
		if(driver instanceof EdgeDriver){
			actPrice = removeLastChar(actPrice);
			expPrice = removeLastChar(expPrice);
		}
		
		//Verify the price displayed on the search result page for the property you clicked on
		//matches the price on the �View Details� page.
		assertEquals(actPrice, expPrice);
		
		driver.close();
		driver.quit();	
		
	}

	
}