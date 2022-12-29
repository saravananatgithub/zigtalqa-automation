package com.zigtal.framework.pageobjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zigtal.test.TestBase;

public class LoginPage {

	WebDriver driver = null;

	@FindBy(id = "email")
	private WebElement userNameElement;

	@FindBy(id = "passowrd")
	private WebElement passwordElement;

	@FindBy(xpath = "//button[normalize-space()='Log In']")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login() {
		userNameElement.sendKeys(TestBase.username);
		passwordElement.sendKeys(TestBase.password);
		loginButton.click();

	}

	public void verifyLogo() {
		assertEquals(driver.findElement(By.xpath("//img[@alt='qademo.zigtallogo']")).isDisplayed(), true);

	}

	public void verifyImage() {

		assertEquals(driver.findElement(By.xpath("//img[@class='img-fluid']")).isDisplayed(), true);
	}

}
