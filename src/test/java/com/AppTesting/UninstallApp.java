package com.AppTesting;

import java.io.IOException;
import org.testng.annotations.Test;

public class UninstallApp {

    @Test
    public void uninstall() throws IOException, InterruptedException {

        String packageName = "com.zeptoconsumerapp"; 

        // 1. Define the absolute path to your adb.exe
        // (Make sure to replace 'ADMIN' with your actual Windows username if it's different)
        String adbPath = "C:\\Users\\ADMIN\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe";

        // 2. Pass the full path command as an array to prevent execution errors
        String[] command = {adbPath, "uninstall", packageName};
        Process process = Runtime.getRuntime().exec(command);

        process.waitFor();

        System.out.println("Zepto app uninstall command executed.");
    }
}