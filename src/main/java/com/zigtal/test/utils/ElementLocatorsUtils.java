package com.zigtal.test.utils;

import java.util.Properties;

public class ElementLocatorsUtils {

	public static Properties xpathProperties;

	public static void initializeElementLocator(Properties p_xpathProperties) {
		xpathProperties = p_xpathProperties;
	}

	public static enum ElementLocators {
		LOGIN_LOGO_LOCATOR(xpathProperties.getProperty("login-logo")),
		LOGIN_IMAGE_LOCATOR(xpathProperties.getProperty("login-image")),
		USERNAME_LOCATOR(xpathProperties.getProperty("username")),
		PASSWORD_LOCATOR(xpathProperties.getProperty("password")),
		LOGINBUTTON_LOCATOR(xpathProperties.getProperty("loginButton"));

		private String locatorValue = "";

		private ElementLocators(String locatorValue) {
			this.locatorValue = locatorValue;
		}

		public String getLocatorValue() {
			return locatorValue;
		}
	}

}
