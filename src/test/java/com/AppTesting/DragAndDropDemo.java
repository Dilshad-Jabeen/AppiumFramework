package com.AppTesting;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Generic.Utility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DragAndDropDemo {

	@Test
	public void dragDropTest() throws InterruptedException {

		AppiumDriver driver = Utility.createDriverSession();

		// set capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		String path = System.getProperty("src//test//resources//ApiDemos-debug.apk");
		options.setApp(path);

		options.setAutomationName("UiAutomator2");
		options.setPlatformName("Android");
		options.setDeviceName("Android");
		options.setCapability("appium:app", path);

		// Click Views
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * AppiumBy.accessibilityId("Views"))).click();
		 */
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// Click Drag and Drop
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

		// Source circle
		WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

		// Target circle
		WebElement target = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));

		// Drag and Drop using W3C Actions
		driver.executeScript("mobile: dragGesture",
				java.util.Map.of("elementId", ((org.openqa.selenium.remote.RemoteWebElement) source).getId(), "endX",
						target.getLocation().getX(), "endY", target.getLocation().getY()));

		Thread.sleep(3000);

		String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();

		System.out.println(result);

		driver.quit();
	}
}