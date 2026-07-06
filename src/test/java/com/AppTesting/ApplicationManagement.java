package com.AppTesting;

import org.testng.annotations.Test;

import com.Generic.Utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ApplicationManagement {
  @Test
  public void testApplicatonCommands() {
	  
	  //create driver session
	 AppiumDriver driver =  Utility.createDriverSession();
	 String appPackage = ((AndroidDriver)driver).getCurrentPackage();
	  
  }
}
