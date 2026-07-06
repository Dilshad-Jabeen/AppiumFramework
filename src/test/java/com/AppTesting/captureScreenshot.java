package com.AppTesting;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.Generic.Utility;

import io.appium.java_client.AppiumDriver;

public class captureScreenshot {

    @Test
    public void captureScreenshot() throws IOException {

        // Launch API Demos application
        AppiumDriver driver = Utility.createDriverSession();

        // Capture screenshot
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Create Screenshots folder if it doesn't exist
        File screenshotDir = new File(System.getProperty("user.dir") + "/Screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdir();
        }

        // Destination file
        File destination = new File(screenshotDir, "ApiDemosHomePage.png");

        // Copy screenshot
        Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Screenshot saved at: " + destination.getAbsolutePath());

        // Close application
        driver.quit();
    }
}