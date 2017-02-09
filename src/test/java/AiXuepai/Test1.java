package AiXuepai;

import DataProvider.DataProvid;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import util.Initialize;
import util.Initialize1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class Test1 {
    AndroidDriver driver;
    Initialize1 initialize= new Initialize1();
    LoginPage loginPage;
    @BeforeMethod
    public  void setUp() throws  Exception {
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize());
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        }

// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @Test(description = "登陆成功",dataProvider = "LoginSucess",dataProviderClass = DataProvid.class)
    public void loginTest1(String username, String pwd) throws Exception {
        Thread.sleep(3000);
        loginPage = new LoginPage(username,pwd,driver);
        loginPage.loginSuccess();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String selectClass = driver.findElement(By.className("android.widget.TextView")).getText();
        //判断进入选择班级页面，即登陆成功
        Assert.assertEquals("选择班级", selectClass);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
