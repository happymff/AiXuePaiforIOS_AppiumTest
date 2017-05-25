package iosTest;

import DataProvider.DataProvid;
import io.appium.java_client.ios.IOSDriver;
import method.ScrollPages;
import method.ScrollPagesFor9;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.IsElementPresent;
import util.StartAppiumServer;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class TeacherLoginTest {
    IOSDriver driverios2;
    util.InitializeDriver initialize;
    StartAppiumServer startAppiumServer;

    @BeforeMethod
    public void setUp() throws Exception {
        startAppiumServer = new StartAppiumServer();
        startAppiumServer.startAppium();
        Thread.sleep(20000);
        initialize = new util.InitializeDriver();
        // initializing driver object
        //driverios = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize("10.1", "iPad mini4", "bfb13a751d799eb97d37dce5e398fe16c5c3fd44"));
        driverios2 = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize("9.3.3", "iPad mini2", "4d5a7ada1f9f8025019021777679610424440b68"));
        // driverios.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "登陆成功", dataProvider = "LoginSucess", dataProviderClass = DataProvid.class)
    public void acceptPush(String username, String pwd, String platv) throws Exception {
        //学生账号进行登录
        int width2 = driverios2.manage().window().getSize().width;
        int height2 = driverios2.manage().window().getSize().height;
        int count =0;
        System.out.println(width2);
        System.out.println(height2);
        if (platv.startsWith("9")) {
            ScrollPagesFor9 scrollPages = new ScrollPagesFor9();

            for (int i = 0; i < 3; i++) {
                scrollPages.scrollRightToLeft(driverios2, (i + 1), width2, height2);
            }
        } else if (platv.startsWith("10")) {
            ScrollPages scrollPages = new ScrollPages();
            for (int i = 0; i < 3; i++) {
                scrollPages.scrollRightToLeft(driverios2, (i + 1), width2, height2);
            }
        } else {
            System.out.println("版本信息错误~~~");
        }
        System.out.println("滑动成功");
        //点击登录按钮
        driverios2.findElement(By.className("UIAButton")).click();
        Thread.sleep(2000);
        System.out.println("点击立即登录按钮成功");
        //输入账号和密码
        driverios2.findElement(By.className("UIATextField")).clear();
        driverios2.findElement(By.className("UIATextField")).sendKeys("AXPC11@ett.com");
        driverios2.findElementByAccessibilityId("login_default_icon").click();
        driverios2.findElement(By.className("UIASecureTextField")).clear();
        driverios2.findElement(By.className("UIASecureTextField")).sendKeys("a11111");
        driverios2.findElementByAccessibilityId("login_default_icon").click();
        //driverios2.tap(1, width2 * 2 / 3, height2 * 1 / 5, 500);
        driverios2.findElement(By.id("登录")).click();
        System.out.println("登录成功");
        //学生账号选择教师
        Thread.sleep(2000);
        IsElementPresent isElementPresent1 = new IsElementPresent();

        int count1 = 0;
        while (!(isElementPresent1.isElementPresent(By.id("飞飞"), driverios2))) {
            System.out.println(isElementPresent1.isElementPresent(By.id("飞飞"), driverios2));
            Thread.sleep(2000);
            count++;
            if (count == 100) {
                break;
            }

        }
        driverios2.findElement(By.id("飞飞")).click();
        driverios2.findElement(By.id("进入课堂")).click();

        for (int i = 0; i < 10000; i++) {
            count++;
            IsElementPresent isElementPresent = new IsElementPresent();
            Boolean isprensent = isElementPresent.isElementPresent(By.id("返回"), driverios2);
            while (true) {
                if (isprensent) {
                    driverios2.findElement(By.id("返回")).click();
                    System.out.println("第" + (i+1) + "次点击返回成功");
                    break;
                } else {
                    Thread.sleep(1000);
                }
            }
        }
        Assert.assertEquals(count1,10000);
    }


    @AfterMethod
    public void tearDown() {
        driverios2.quit();
    }
}
