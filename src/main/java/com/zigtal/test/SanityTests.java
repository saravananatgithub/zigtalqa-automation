package com.zigtal.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SanityTests extends TestBase {

	@Test
	public void login() {
		assertEquals(driver.findElement(By.xpath(ElementLocators.LOGIN_LOGO_LOCATOR.getLocatorValue())).isDisplayed(),
				true);
		assertEquals(driver.findElement(By.xpath(ElementLocators.LOGIN_IMAGE_LOCATOR.getLocatorValue())).isDisplayed(),
				true);
		loginPage.login();
	}

}
