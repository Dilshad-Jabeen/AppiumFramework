//package com.Generic;
//
//import java.net.URL;
//import java.time.Duration;
//
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//
//public class Utility {
//
//    public static AppiumDriver createDriverSession() {
//
//        AppiumDriver driver = null;
//
//        try {
//
//            DesiredCapabilities cap = new DesiredCapabilities();
//
//            cap.setCapability("platformName", "Android");
//            cap.setCapability("automationName", "UiAutomator2");
//            cap.setCapability("deviceName", "Android Emulator");
//
//            // Change this path if required
//            cap.setCapability("app",
//                    "C:\\Users\\ADMIN\\Downloads\\ApiDemos-debug.apk");
//
//            driver = new AndroidDriver(
//                    new URL("http://127.0.0.1:4723"),
//                    cap);
//
//            driver.manage().timeouts()
//                    .implicitlyWait(Duration.ofSeconds(10));
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//
//        return driver;
//    }
//}

//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URL;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//
//public class Utility {
//
//	public static AppiumDriver driver;
//
//	public static AppiumDriver createDriverSession()
//	{
//		// set the capability
//		UiAutomator2Options option = new UiAutomator2Options();
//		String path = System.getProperty("user.dir") + "src//test//resources//ApiDemos-debug.apk";
//		
//		option.setCapability("appium:app", path);
//
//		try {
//			// server address
//			URL url = new URI("http://192.168.29.35:4723").toURL();
//			System.out.println(driver);
//
//			// create driver session
//			driver = new AndroidDriver(url, option);
//			System.out.println("Session id is :" + driver.getSessionId());
//		} catch (Exception e) {
//		}
//
//		return driver;
//	}
//
//}

package com.Generic;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Utility {

    public static AppiumDriver driver;

    public static AppiumDriver createDriverSession() {

        try {

            UiAutomator2Options options = new UiAutomator2Options();

            String appPath = System.getProperty("user.dir")
                    + "/src/test/resources/ApiDemos-debug.apk";

            System.out.println("APK Path: " + appPath);

            options.setApp(appPath);
            options.setAutomationName("UiAutomator2");
            options.setPlatformName("Android");
            options.setDeviceName("Android Emulator"); // or your device name

            URL url = new URI("http://127.0.0.1:4723").toURL();

            driver = new AndroidDriver(url, options);

            driver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

            System.out.println("Session ID: " + driver.getSessionId());

        } catch (Exception e) {

            e.printStackTrace();
        }

        return driver;
    }
}
