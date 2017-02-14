package AiXuepai;

import DataProvider.DataProvid;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.LoginPageForStudent;
import util.Initialize;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class LoginTest1 {
    AndroidDriver driver;
    Initialize initialize= new Initialize();
    LoginPageForStudent loginPage;
    @BeforeMethod
    public  void setUp() throws  Exception {

       //initialize = new Initialize();
        // initializing driver object
       // DesiredCapabilities caps =initialize.driverInitialize();
        driver = new AndroidDriver(new URL(" http://127.0.0.1:4725/wd/hub"), initialize.driverInitialize());
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @Test(description = "学生云账号2登录",dataProvider = "StudentLogin",dataProviderClass = DataProvid.class)
    public void loginTest(String username, String pwd) throws Exception {
        Thread.sleep(2000);
        loginPage = new LoginPageForStudent(username,pwd,driver);
        loginPage.studentLogin();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String selectTeacher = driver.findElement(By.className("android.widget.TextView")).getText();
        //判断进入选择班级页面，即登陆成功
        Thread.sleep(2000);
        Assert.assertEquals("选择上课老师", selectTeacher);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
