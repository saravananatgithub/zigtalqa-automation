package com.zigtal.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class SanityTests extends TestBase {

	@Test
	public void login() {
		assertEquals(loginPage.checkIfLoginLogoPresent(), true);
		assertEquals(loginPage.checkIfLoginImagePresent(), true);
		loginPage.login();
	}

}