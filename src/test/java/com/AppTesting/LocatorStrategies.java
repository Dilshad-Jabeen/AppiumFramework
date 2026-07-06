package com.AppTesting;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generic.Utility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LocatorStrategies {

    @Test
    public void testLocators() {

        // Create Appium driver session
        AppiumDriver driver = Utility.createDriverSession();

        // Locate using Accessibility ID
        WebElement accessibility = driver.findElement(
                AppiumBy.accessibilityId("Accessibility"));

        // Print text
        System.out.println("Text of the element: " + accessibility.getText());

        // Verify text
        Assert.assertEquals(accessibility.getText(), "Accessibility");

        // Click on the element
        accessibility.click();

        // Close the application
        driver.quit();
    }
}


//package com.AppTesting;
//
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//
//import com.Generic.Utility;
//
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.AppiumDriver;
//
//public class LocatorStrategies {
//  @Test
//  public void testLocators(){
//	  
//	  //create a Appium driver session
//  
//	  AppiumDriver driver = Utility.createDriverSession();
//	  
//	  WebElement elm1 = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
//	  
//	  System.out.println("Text of the element1" + elm1.getText());
//	  //click
//	  elm1.click();
// 
//  }
//  
//}
