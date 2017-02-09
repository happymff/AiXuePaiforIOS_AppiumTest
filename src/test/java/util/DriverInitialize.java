package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverInitialize {
        protected AndroidDriver driver;
        protected WebDriverWait wait;
        String platformName ="ANDROID";
        String apkname="app-aixuepai.apk";
        String devicename="V8OBMJ7H99999999";
        String platormVersion="5.0.1";
        Boolean install =false;
    //      public void driverInitialize("ANDROID","app-aixuepai.apk","NF5PONSC99999999","5.0.1",false) throws Exception {

    @BeforeMethod
      public void driverInitialize() throws Exception {
        // set up appium

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/test/resource/apps/");
        File app = new File(appDir,apkname);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName",platformName);
        capabilities.setCapability("deviceName", devicename);
        capabilities.setCapability("platformVersion",platormVersion);
     //support Chinese
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
        //capabilities.setCapability("appActivity", appActivity);
       if(install ==true) {
         capabilities.setCapability("app", app.getAbsolutePath());
         capabilities.setCapability("appPackage", apkname);
       }
          // initializing driver object
          driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
// initializing explicit wait object
          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          wait = new WebDriverWait(driver, 10);
    }
    @AfterMethod
    public void closeDriver() throws Exception {
        driver.quit();
    }

}