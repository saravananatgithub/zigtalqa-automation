package com.zigtal.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.zigtal.framework.pageobjects.LoginPage;
import com.zigtal.test.utils.ElementLocatorsUtils;
import com.zigtal.test.utils.TestDataUtils;

public class TestBase {
	public static Properties properties = new Properties();
	public static Properties tenantTestDataProperties = new Properties();
	public static Properties tenantLocatorProperties = new Properties();
	public static String testEnv = "";
	public static String tenant = "";

	static {
		java.net.URL url = ClassLoader.getSystemResource("env.properties");
		try {
			properties.load(url.openStream());
			testEnv = properties.getProperty("testenv");
			tenant = properties.getProperty("tenant");
			System.out.println(testEnv + "/" + tenant + "/locator.properties");
			url = ClassLoader.getSystemResource(testEnv + "/" + tenant + "/locator.properties");
			tenantLocatorProperties.load(url.openStream());
			ElementLocatorsUtils.initializeElementLocator(tenantLocatorProperties);
			
			url = ClassLoader.getSystemResource(testEnv + "/" + tenant + "/data.properties");
			tenantTestDataProperties.load(url.openStream());
			TestDataUtils.initializeTestData(tenantTestDataProperties);
		} catch (FileNotFoundException fie) {
			fie.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver driver;
	public static LoginPage loginPage = null;

//	public static String username = properties.getProperty(testEnv + ".username");
//	public static String password = properties.getProperty(testEnv + ".password");

	public static String hostName = properties.getProperty(testEnv + ".hostname");
	public static String baseUrl = "https://" + hostName; // + "/signin?redirectUrl=%2Fhome";
	public static String chromeDriverPath = properties.getProperty("driver-path");

	private String profileImageXpath = "//img[@alt='profile picture']";
	private String logoutXpath = "//a[normalize-space()='Logout']";

	protected void threadwait(int k) {
		try {
			Thread.sleep(k);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void beforeTest() {
		System.out.println("Before Class");

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginPage = new LoginPage(driver);
		driver.get(baseUrl);
		threadwait(8000);

	}

	@AfterClass
	public void afterTest() {
		System.out.println("After Class");
		threadwait(10000);
		driver.findElement(By.xpath(profileImageXpath)).click();
		driver.findElement(By.xpath(logoutXpath)).click();
		driver.close();

	}

}