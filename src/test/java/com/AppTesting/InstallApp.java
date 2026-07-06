package com.AppTesting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.testng.annotations.Test;

public class InstallApp {

    @Test
    public void installTargetApp() throws IOException, InterruptedException {
        // 1. Path to your ADB executable
        String adbPath = "C:\\Users\\ADMIN\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe";
        
        // 2. Change this to the path of the APK you want to install
        // Example: "C:\\Users\\ADMIN\\Downloads\\ZohoBooks.apk"
        String apkPath = "C:\\Users\\ADMIN\\Downloads\\ZohoBooks.apk"; 
        
     // 3. Command array (simplified for a single connected device)
        String[] command = {adbPath, "install", "-r", apkPath};

        System.out.println("Initiating installation on the connected device...");
        Process process = Runtime.getRuntime().exec(command);

        // 4. Capture and print live console logs from ADB
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        
        while ((line = reader.readLine()) != null) {
            System.out.println("ADB Output: " + line);
        }
        while ((line = errorReader.readLine()) != null) {
            System.err.println("ADB Error: " + line);
        }

        int exitCode = process.waitFor();

        // 5. Evaluate the final result
        if (exitCode == 0) {
            System.out.println("SUCCESS: App installed or updated perfectly!");
        } else {
            System.out.println("FAILURE: Installation failed. Check the ADB error log above.");
        }
    }
}
















//package com.AppTesting;
//
//import java.io.IOException;
//import org.testng.annotations.Test;
//
//public class InstallApp {
//
//    @Test
//    public void installApp() throws IOException, InterruptedException {
//        // 1. Path to your ADB executable
//        String adbPath = "C:\\Users\\ADMIN\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe";
//        
//        // 2. Absolute path to where your Zepto APK file is stored on your computer
//        // (Update this path to match exactly where you saved your downloaded .apk file)
//        String apkPath = "C:\\Users\\ADMIN\\Downloads\\zepto-app.apk"; 
//
//        // 3. Create the command array: adb install <path-to-apk>
//        String[] command = {adbPath, "install", apkPath};
//        
//        System.out.println("Installing Zepto app...");
//        Process process = Runtime.getRuntime().exec(command);
//
//        // Wait for the installation to finish
//        int exitCode = process.waitFor();
//
//        if (exitCode == 0) {
//            System.out.println("Zepto app installed successfully!");
//        } else {
//            System.out.println("Failed to install Zepto app. Exit code: " + exitCode);
//        }
//    }
//}