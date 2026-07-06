package com.DriverSession;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverSessionUsingAppPackage_Activity {
	@Test
	public void testSession() throws MalformedURLException, URISyntaxException {

		// set the capabilities
		UiAutomator2Options option = new UiAutomator2Options();
		
		//Launching the Calculator
		option.setCapability("appium:appPackage", "com.sec.android.app.popupcalculator");
		option.setCapability("appium:appActivity", "com.sec.android.app.popupcalculator.Calculator");

		// server address
		URL url = new URI("http://192.168.29.35:4723").toURL();

		// Create Appium driver session
		System.out.println("Attempting to connect to Appium Server...");
		AppiumDriver driver = new AndroidDriver(url, option);
		System.out.println("Session id is :" + driver.getSessionId());

	}
}
