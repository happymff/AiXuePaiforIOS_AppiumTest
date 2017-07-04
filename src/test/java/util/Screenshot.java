package util;

/**
 * Created by mff on 2017/5/11.
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({ScreenshotListener.class})
public class Screenshot {
    static AppiumDriver driver;
//
//    @BeforeClass
//    public void setUp() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName", "AndroidUI");
//        capabilities.setCapability("platformVersion", "1.0");
//        capabilities.setCapability("appPackage", "com.android.androidui");
//        capabilities.setCapability("appActivity", "com.android.androidui.MainActivity");
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void testExample() throws IOException {
//        WebElement spinner = driver.findElement(By.id("android:id/text1"));
//        spinner.click();
//        driver.scrollToExact("India");
//        WebElement optionindia = driver.findElement(By.name("India"));
//        optionindia.click();
//        WebElement result = optionindia;
////Check the calculated value on the edit box
//        assert result.getText().equals("France") : "Actual value is :" + result.getText() + " did not match with expected value: France";
//    }
//
//    @AfterClass
//    public void tearDown() {
//        driver.closeApp();
//    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}