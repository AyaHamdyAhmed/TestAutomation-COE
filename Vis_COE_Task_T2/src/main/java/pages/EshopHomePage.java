package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EshopHomePage extends PageBaseClass {

	public EshopHomePage(WebDriver driver) {
		super(driver);
		
	}
	public void navigateToURL(String URL) {
		driver.navigate().to(URL);
	}
	
	@FindBy(id="search-q")
	WebElement searchBox;
	
public void searchQuery(String text) {
 searchBox.sendKeys(text);
 searchBox.sendKeys(Keys.ENTER);
}
}
