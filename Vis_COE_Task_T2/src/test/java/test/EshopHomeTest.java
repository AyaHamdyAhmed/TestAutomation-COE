package test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import data.Browser;
import data.ExcelReader;
import pages.EshopHomePage;
import pages.ResultsPage;

public class EshopHomeTest {
	EshopHomePage homeObject;
	ResultsPage resultObject;
	WebDriver browserObject;
	@DataProvider(name="ExcelData")
	public Object[][] EshopData() throws IOException{
		/*
		 * get data from excel reader class
		 * */
		ExcelReader er = new ExcelReader();

		return er.getExcelData();

	}
	@BeforeClass
	@Parameters("Browser")
	public void beforeClass(String browserName) {
		Browser B = new Browser();
		B.setBrowser(browserName);
		browserObject = Browser.getBrowser();
	}
	
	@Test(priority=1,alwaysRun=true,dataProvider="ExcelData")
	public void userSearch(String URL, String searchKeyword,String expectedUrl,String searchres) {
		homeObject = new EshopHomePage(browserObject);
		homeObject.navigateToURL(URL);
		homeObject.searchQuery(searchKeyword);
		resultObject = new ResultsPage(browserObject);
		String url= resultObject.checkUrl();
		assertEquals(url.contains(expectedUrl), expectedUrl);
		resultObject.searchResults(searchres);
	}

/*	@Test(dependsOnMethods= {"userSearch"})
	public void Queryresult() {
		
	}*/
	

	@AfterClass
	public void afterClass() {
		browserObject.close();
	}

}
