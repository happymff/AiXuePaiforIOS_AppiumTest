package iosTest;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;


public class InitializeDriver {


    public DesiredCapabilities driverInitialize(String platv, String devName, String udid) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "iOS");

        caps.setCapability("platformVersion",platv);
        //caps.setCapability("platformVersion", "10.1");
        caps.setCapability("deviceName", devName);
        //caps.setCapability("deviceName", "iPad mini4");
        caps.setCapability("automationName","XCUITest");
        caps.setCapability("autoAcceptAlerts", "True");
        //caps.setCapability("autoWebview","true");
        caps.setCapability("noReset","false");
        //caps.setCapability("fullReset","true");
        caps.setCapability("udid",udid);
        //caps.setCapability("udid","bfb13a751d799eb97d37dce5e398fe16c5c3fd44");
        caps.setCapability("bundleId","com.etiantian.ettaixuepai");
// relative path to .app file
        final File classpathRoot = new File(System.getProperty("user.dir"));
        final File appDir = new File(classpathRoot, "src/test/resource/");
        final File app = new File(appDir, "ettAiXuePaiNextGen.app");
        caps.setCapability("app", app.getAbsolutePath());

        return caps;
    }
}
