package test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
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
	@BeforeSuite
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		System.out.print("browserName  " + browser);
		//Browser B = new Browser();
		Browser.setBrowser(browser);
		
		System.out.println("ayahhhhhhhhhhhhhhhhhhhh");
		browserObject = Browser.getBrowser();
		System.out.println("ayaaaaaaaaaaaaaaaa");
	}
	
	
	
	@Test(dataProvider="EshopData")
	public void userSearch(String URL, String searchKeyword,String expectedUrl,String searchres) {
		homeObject = new EshopHomePage(browserObject);
		homeObject.navigateToURL(URL);
		System.out.println(URL);
		browserObject.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		homeObject.searchQuery(searchKeyword);
		resultObject = new ResultsPage(browserObject);
		String url= resultObject.checkUrl();
		assertEquals(url.contains(expectedUrl), expectedUrl);
		resultObject.searchResults(searchres);
		System.out.println("testtttttttttttttttttttttttt");
	}

	@DataProvider
	public Object[][] EshopData() throws Exception{
		/*
		 * get data from excel reader class
		 * */
		ExcelReader er = new ExcelReader();
		Object[][] exceldata = er.getExcelData();
	//	System.out.println(exceldata);
		System.out.println("Dataaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return exceldata;
		//return er.getExcelData();

	}
	
	
/*	@Test(dependsOnMethods= {"userSearch"})
	public void Queryresult() {
		
	}*/
	

	@AfterClass
	public void afterClass() {
		browserObject.quit();
	}

}
