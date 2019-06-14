package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class ResultsPage extends PageBaseClass{

	public ResultsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//p[@class='no-gutter no-gutter--top']//strong[1]")
	WebElement searchRes;
public String checkUrl() {
	String link= driver.getCurrentUrl();
	return link;
}

public void searchResults(String res) {
Assert.assertEquals(searchRes.getText(), res);
}
}
