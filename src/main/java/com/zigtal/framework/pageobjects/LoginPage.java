package com.zigtal.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.zigtal.test.TestBase;
import com.zigtal.test.TestBase.ElementLocators;

public class LoginPage {

	WebDriver driver = null;

	private WebElement userNameElement;

	private WebElement passwordElement;

	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login() {
		userNameElement = driver.findElement(By.id(ElementLocators.USERNAME_LOCATOR.getLocatorValue()));
		passwordElement = driver.findElement(By.id(ElementLocators.PASSWORD_LOCATOR.getLocatorValue()));
		loginButton = driver.findElement(By.xpath(ElementLocators.LOGINBUTTON_LOCATOR.getLocatorValue()));
		userNameElement.sendKeys(TestBase.username);
		passwordElement.sendKeys(TestBase.password);
		loginButton.click();

	}

}
