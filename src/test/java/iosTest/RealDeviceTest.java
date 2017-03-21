package iosTest;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class RealDeviceTest {
    IOSDriver driver;
    iosTest.InitializeDriverRealDevice initialize;
    @BeforeMethod
    public  void setUp() throws  Exception {

       initialize = new iosTest.InitializeDriverRealDevice();
        // initializing driver object
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize());
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @Test
    public void loginTest() throws Exception {
        driver.findElement(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")).sendKeys("AppiumBook");
        driver.findElement(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]")).sendKeys("First TC");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
