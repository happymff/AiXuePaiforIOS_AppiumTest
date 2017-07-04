package iosTest;

import DataProvider.DataProvid;
import io.appium.java_client.ios.IOSDriver;
import method.Login;
import method.ScrollPages;
import method.ScrollPagesFor9;
import method.SelectClass;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.InitSetup;
import util.InitializeDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mff on 2017/3/28.
 */
public class SelectClassTest {
    IOSDriver driverios;
    InitSetup is;
    Login login;
    SelectClass selectClass;
    @BeforeClass
    public void setUp() throws Exception {
        is = new InitSetup();
        driverios = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), is.InitSetUpCFG(new DesiredCapabilities()));
        driverios.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "登陆成功", dataProvider = "LoginSucess", dataProviderClass = DataProvid.class)
    public void selectClassSucessTest(String username, String pwd, String platv) throws Exception {
        driverios.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        int width = driverios.manage().window().getSize().width;
        int height = driverios.manage().window().getSize().height;
        System.out.println("屏幕宽度：" + width);
        System.out.println("屏幕长度：" + height);
        if(platv.startsWith("9")) {
            ScrollPagesFor9 scrollPages = new ScrollPagesFor9();
            for(int i = 0; i <3 ;i ++) {
                scrollPages.scrollRightToLeft(driverios, (i+1), width, height);
            }
        }else if(platv.startsWith("10")){
            ScrollPages scrollPages = new ScrollPages();
            for(int i = 0; i <3 ;i ++) {
                scrollPages.scrollRightToLeft(driverios, (i+1), width, height);
            }
        }else {
            System.out.println("版本信息错误~~~");
        }
        driverios.findElement(By.className("UIAButton")).click();
        login = new Login();
        login.loginSucess(driverios, username,pwd);
        selectClass = new SelectClass();
        selectClass.selectClass(driverios);
        Thread.sleep(2000);
        Assert.assertEquals("学生管理",driverios.findElement(By.id("学生管理")).getText());
    }

    @AfterClass
    public void tearDown() {
        driverios.quit();
    }
}
