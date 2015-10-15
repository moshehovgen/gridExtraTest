package com.perion;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverTests {

	public final String hubUrl = "http://172.16.32.9";
	private final String hubPort = "4444";
	private final String webHub = "wd/hub";
	private DesiredCapabilities capability = DesiredCapabilities.firefox();
	
	private WebDriver driver;

	@Before
	public void setUp() {
		try {
			//capability.setBrowserName("firefox");
			//capability.setPlatform(Platform.WINDOWS);
			//capability.setVersion("41.0.1");
			
			String hubUrl = this.hubUrl + ":" + hubPort + "/" + webHub;
			URL hubURL = new URL(hubUrl);
			System.out.println("hubUrl " + hubUrl);
			driver = new RemoteWebDriver(hubURL, capability);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public WebDriver initWebDriver() {
		WebDriver driver;
		DesiredCapabilities capabilities = null;
		switch (System.getenv("BROWSER_TYPE")) {

		case "firefox":
			System.out.println("init FF webdriver");
			capabilities = DesiredCapabilities.firefox();
			return new FirefoxDriver();

		case "chrome":
			String chromeLocation = System.getenv("AUTOMATION_HOME") + File.separator
					+ "/drivers/chrome/chromedriver.exe";
			// String chromeLocation = "/drivers/chrome/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeLocation);
			System.out.println("init CH webdriver");
			capabilities = DesiredCapabilities.firefox();
			return new ChromeDriver();

		case "ie":
			String ieLocation = "";
			// if(isOs64Bit())
			// ieLocation = System.getenv("AUTOMATION_HOME") + File.separator +
			// "/drivers/ie/IEDriverServer_x64/IEDriverServer.exe";
			// else
			// addKeyForIE();
			ieLocation = System.getenv("AUTOMATION_HOME") + File.separator
					+ "/drivers/ie/IEDriverServer_Win32/IEDriverServer.exe";

			System.setProperty("webdriver.ie.driver", ieLocation);
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("enablePersistentHover", false);
			System.out.println("init IE webdriver");
			return new InternetExplorerDriver(capabilities);

		case "safari":
			System.out.println("init safari webdriver");
			capabilities = DesiredCapabilities.safari();
			capabilities.setPlatform(Platform.WINDOWS);
			return new SafariDriver(capabilities);
		default:
			new FirefoxDriver();

		}

		driver = new RemoteWebDriver(capabilities);
		// default if no valid browser value
		return driver;
	}

	@After
	public void stop() {
		driver.quit();
	}

	@Test
	public void navigateToGooglePageSearchATermAndNavigateToFirstResult() {
		System.out.println("navigate To Google Page Search A Term And Navigate To First Result");
		GoogleWebSite webSite = new GoogleWebSite(driver);
		System.out.println("before navigation");
		webSite.navigate();
		System.out.println("after navigation");
		System.out.println("before searchATermAndgetResults fun");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> results = webSite.searchATermAndgetResults("hovagen");
		System.out.println("after searchATermAndgetResults fun");
		System.out.println("after click On First Result fun");
		webSite.clickOnResult(results.get(0));
		System.out.println("after click On First Result fun");

	}

	@Test
	public void navigateToGooglePageSearchATermAndNavigateToSecondResult() {
		System.out.println("navigate To Google Page Search A Term And Navigate To Second Result");
		GoogleWebSite webSite = new GoogleWebSite(driver);
		System.out.println("before navigation");
		webSite.navigate();
		System.out.println("after navigation");
		System.out.println("before searchATermAndgetResults fun");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> results = webSite.searchATermAndgetResults("hovagen");
		System.out.println("after searchATermAndgetResults fun");
		System.out.println("after click On Second Result fun");
		webSite.clickOnResult(results.get(0));
		System.out.println("after click On Second Result fun");

	}

	@Test
	public void navigateToGooglePageSearchATermAndNavigateToLastResult() {
		System.out.println("navigate To Google Page Search A Term And Navigate To Last Result");
		GoogleWebSite webSite = new GoogleWebSite(driver);
		System.out.println("before navigation");
		webSite.navigate();
		System.out.println("after navigation");
		System.out.println("before searchATermAndgetResults fun");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> results = webSite.searchATermAndgetResults("hovagen");
		System.out.println("after searchATermAndgetResults fun");
		System.out.println("after click On Last Result fun");
		webSite.clickOnResult(results.get(0));
		System.out.println("after click On Last Result fun");

	}

}
