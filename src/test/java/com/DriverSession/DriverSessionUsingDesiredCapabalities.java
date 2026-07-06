package com.DriverSession;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverSessionUsingDesiredCapabalities {
  @Test
  public void testDriverSession() throws MalformedURLException, URISyntaxException {
	  
	  //set the capabalities
	  DesiredCapabilities cap = new DesiredCapabilities();
	  cap.setCapability("platformName", "Android");
	  cap.setCapability("appium:automationName", "UiAutomator2");
	  cap.setCapability("appium:deviceName", "pixel_7");
	  cap.setCapability("appium:udid", "emulator-5554");
	  String path = System.getProperty("user.dir")+"src//test//resources//ApiDemos-debug.apk";
	  cap.setCapability("appium:app",path);
	  
	  // server address
	  URL url = new URI("http://0.0.0.4723").toURL();
	  
	  //create Appium driver session
	  System.out.println("Attempting to connect to Appium Server...");
	  AppiumDriver  driver = new AndroidDriver(url,cap);
	  System.out.println("Session id is : "+driver.getSessionId());
	  
  }
  
  
}
