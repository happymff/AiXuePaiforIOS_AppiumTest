package TestGrid;

import DataProvider.DataProvid;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPageForStudent;
import page.SelectTeacher;
import page.SwitchLoginPageYindaoImage;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class SelectTeacherTest1 {
    AndroidDriver driver;
    InitializeDriver initialize;
    LoginPageForStudent loginPage;
    SwitchLoginPageYindaoImage switchLoginPageYindaoImage;
    SelectTeacher selectTeacher;
    @BeforeMethod
    public  void setUp() throws  Exception {
       initialize = new InitializeDriver("192.168.56.103:5555","7.0");
        // initializing driver object
       // DesiredCapabilities caps =initialize.driverInitialize();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"), initialize.driverInitialize());
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }


    @Test(description = "学生云账号2登录",dataProvider = "StudentLogin1",dataProviderClass = DataProvid.class)
    public void selectClassTest(String username, String pwd) throws Exception {
        loginPage = new LoginPageForStudent(username,pwd,driver);
        Thread.sleep(2000);
        loginPage.studentLogin();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(3000);
        selectTeacher = new SelectTeacher(driver);
        selectTeacher.selectTeacher();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals("高一英语",driver.findElement(By.id("com.etiantian.pclass:id/lftc_txt_title")).getText());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
