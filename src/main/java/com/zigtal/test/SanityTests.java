package com.zigtal.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SanityTests extends TestBase {

	@Test
	public void login() {
		System.out.println("--------" +loginLogoXpath);
		assertEquals(driver.findElement(By.xpath(loginLogoXpath)).isDisplayed(), true);
		assertEquals(driver.findElement(By.xpath(loginImageXpath)).isDisplayed(), true);
		loginPage.login();
	}

}
