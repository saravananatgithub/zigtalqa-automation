package com.zigtal.test.utils;

import java.util.Properties;

public class TestDataUtils {

	public static Properties testDataProperties;

	public static void initializeTestData(Properties p_testDataProperties) {
		testDataProperties = p_testDataProperties;
	}

	public static enum TestDataEnum {

		USERNAME(testDataProperties.getProperty("username")), PASSWORD(testDataProperties.getProperty("password"));

		private String testData = "";

		private TestDataEnum(String testData) {
			this.testData = testData;
		}

		public String getTestData() {
			return testData;
		}
	}

}
