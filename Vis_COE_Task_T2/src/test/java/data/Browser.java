package data;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	static WebDriver browserObject;

	public void setBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions opt = new FirefoxOptions();
			opt.addPreference("dom.webnotifications.enabled", false);
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			browserObject = new FirefoxDriver(opt);

		} else if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			browserObject = new ChromeDriver(ops);
		} else if(browserName.equalsIgnoreCase("ie")){
			//set path to IE.exe
			System.setProperty("webdriver.ie.driver","src/test/resources/drivers/IEDriverServer.exe");
			//create IE instance
			browserObject = new InternetExplorerDriver();
		}
else{
	//If no browser passed throw exception
	try {
		throw new Exception("Browser is not correct");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

		browserObject.manage().window().maximize();
		browserObject.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static WebDriver getBrowser() {
		return browserObject;
	}
}
