package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class PageBaseClass {
	
	protected WebDriver driver;

	/**
	 * create constructor 
	 * */
	public PageBaseClass(WebDriver driver) {
		//this.driver= driver;
		PageFactory.initElements(driver, this);
	}	
}
