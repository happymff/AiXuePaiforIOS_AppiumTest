package iosTest;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;


public class InitializeDriverRealDevice {


    public DesiredCapabilities driverInitialize() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "iOS");
        caps.setCapability("platformVersion", "10.2");
        caps.setCapability("deviceName", "iPhone 6s");
        caps.setCapability("automationName","XCUITest");
      //  caps.setCapability("udid","ca048cc7695cad07a45e82d58ba88d0bb21b943f");
        caps.setCapability("bundleId","io.ett.TestApp");
// relative path to .app file
        final File classpathRoot = new File(System.getProperty("user.dir"));
        final File appDir = new File(classpathRoot, "src/test/resource/");
        final File app = new File(appDir, "TestApp.app");
        caps.setCapability("app", app.getAbsolutePath());

        return caps;
    }
}
