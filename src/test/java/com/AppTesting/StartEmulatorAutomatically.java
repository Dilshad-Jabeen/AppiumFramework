package com.AppTesting;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class StartEmulatorAutomatically {
  @Test
  public void testDriverSessionToLaunchEmulator() throws MalformedURLException, URISyntaxException {
	  
	  //set the capability
	  UiAutomator2Options option = new UiAutomator2Options();
	  String path = System.getProperty("src//test//resources//ApiDemos-debug.apk");
	  option.setCapability("appium:app",path);
	  
	  option.setCapability("appium:avd", "Pixel_7");
	  option.setCapability("appium:avdLaunchTimeout",300000);
	  
		// server address
		URL url = new URI("http://192.168.29.35:4723").toURL();
		
		// Create Appium driver session
		System.out.println("Attempting to connect to Appium Server...");
		AppiumDriver driver = new AndroidDriver(url, option);
		System.out.println("Session id is :" + driver.getSessionId());

  }
}
