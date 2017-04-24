package util;

import java.io.IOException;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

public class StartAppiumServer {
    public static Process p;
    // Set path of your node.exe file.
    // Progra~1 represents Program Files folder.
    public static  String nodePath = "/usr/local/bin/node";
    // Set path of your appium.js file.
    public static  String appiumJSPath = "/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js";
    public static  String cmd = nodePath + " " + appiumJSPath;
    IOSDriver<WebElement> driver;

    // This method Is responsible for starting appium server.
    public static void appiumStart() throws IOException, InterruptedException {
        // Execute command string to start appium server.
        p = Runtime.getRuntime().exec(cmd);

        // Provide wait time of 10 mins to start appium server properly.
        // If face any error(Could not start a new session...) then Increase
        // this time to 15 or 20 mins.
        Thread.sleep(10000);
        if (p != null) {
            System.out.println("Appium server Is started now.");
        }
    }

    // This method Is responsible for stopping appium server.
    public static void appiumStop() throws IOException {
        System.out.println(p);
        if (p != null) {
            p.destroy();
        }
        System.out.println("Appium server Is stopped now.");
    }

    public static void startAppium() throws IOException, InterruptedException {
        System.out.println("come here for start Appium server");
        appiumStop();
        appiumStart();
    }

    public static void main(String[] args) throws IOException, Exception {
        StartAppiumServer.startAppium();
    }
}