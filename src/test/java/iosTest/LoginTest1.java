package iosTest;

import DataProvider.DataProvid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import method.DotTestListener;
import method.Login;
import method.ScrollPages;
import method.ScrollPagesFor9;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mff on 2017/3/28.
 */

//@Listeners({DotTestListener.class})
public class LoginTest1 {
    static IOSDriver driverios;
    InitializeDriver initialize;
    Login login;

    @BeforeMethod
    public void setUp() throws Exception {
        StartAppiumServer startAppiumServer;
        startAppiumServer = new StartAppiumServer();
        startAppiumServer.startAppium();
        Thread.sleep(20000);

        initialize = new InitializeDriver();
        driverios = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize("9.3.3", "iPad mini2", "4d5a7ada1f9f8025019021777679610424440b68"));
        //driverios = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize("10.1", "iPad mini4", "bfb13a751d799eb97d37dce5e398fe16c5c3fd44"));
        driverios.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "登陆成功", dataProvider = "LoginSucess", dataProviderClass = DataProvid.class)
    public void loginFaildTest(String username, String pwd, String platv) throws Exception {
        driverios.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        int width = driverios.manage().window().getSize().width;
        int height = driverios.manage().window().getSize().height;
        System.out.println("屏幕宽度：" + width);
        System.out.println("屏幕长度：" + height);
        if (platv.startsWith("9")) {
            ScrollPagesFor9 scrollPages = new ScrollPagesFor9();
            for (int i = 0; i < 3; i++) {
                scrollPages.scrollRightToLeft(driverios, (i + 1), width, height);
            }
        } else if (platv.startsWith("10")) {
            ScrollPages scrollPages = new ScrollPages();
            for (int i = 0; i < 3; i++) {
                scrollPages.scrollRightToLeft(driverios, (i + 1), width, height);
            }
        } else {
            System.out.println("版本信息错误~~~");
        }
        driverios.findElement(By.className("UIAButton")).click();
        login = new Login();
        login.loginSucess(driverios, username, pwd);
        IsElementPresent isElementPresent = new IsElementPresent();
        WebElement result1 = driverios.findElement(By.id("请选择上课班级"));
        result1.click();
        WebElement result = result1;
        System.out.println(result.getText());
        //ScreenshotListener screenshotListener = new ScreenshotListener();
        Assert.assertEquals("请选择上课班级1",result.getText());
        String s = String.valueOf(driverios.manage().logs().get("crashlog"));
        System.out.println(s);
    }
        @AfterMethod
        public void tearDown () {
            driverios.quit();
        }

    public static IOSDriver getDriver() {
        return driverios;
    }
}
