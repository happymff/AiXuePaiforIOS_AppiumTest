package iosTest;

import DataProvider.DataProvid;
import io.appium.java_client.ios.IOSDriver;
import method.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.AutoLogger;
import util.InitSetup;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class PushWhiteBoardTimes {
    private static AutoLogger logger = AutoLogger.getLogger(FinshPushClassTest.class);
    IOSDriver driverios;
    InitSetup is;
    PushWhiteBoard pushWhiteBoard;
    Login login;
    SelectClass selectClass;

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test(description = "登陆成功", dataProvider = "LoginSucess", dataProviderClass = DataProvid.class)
    public void pushWhiteBoard(String username, String pwd, String platv) throws Exception {
        for (int k = 0; k < 100; k ++) {
            System.out.println("——————————————————————第"+(k+1)+"次循环————————————————————————");
            is = new InitSetup();
            driverios = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), is.InitSetUpCFG(new DesiredCapabilities()));
            driverios.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            logger.log("This is pushWhiteBoard log");
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
            selectClass = new SelectClass();
            selectClass.selectClass(driverios);
            pushWhiteBoard = new PushWhiteBoard();
            pushWhiteBoard.pushWhiteBoard(driverios);
            Thread.sleep(20000);
            Assert.assertEquals("结束推送", driverios.findElement(By.id("结束推送")).getText());
            driverios.quit();
        }
    }


    @AfterMethod
    public void tearDown() {
        //driverios.resetApp();
         //driverios.quit();
    }
}
