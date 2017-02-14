package TestGrid;

import DataProvider.DataProvid;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.SelectClass;
import page.SelectClassMode;
import page.SwitchLoginPageYindaoImage;
import util.Initialize;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class TeacherSelectClassTest {
    AndroidDriver driver;
    InitializeDriver initialize;
    LoginPage loginPage;
    SwitchLoginPageYindaoImage switchLoginPageYindaoImage;
    SelectClassMode selectClassMode;
    @BeforeMethod
    public  void setUp() throws  Exception {
       initialize = new InitializeDriver("192.168.56.101:5555","5.1");
        // initializing driver object
       // DesiredCapabilities caps =initialize.driverInitialize();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize());
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test(description = "云账号测试",dataProvider = "TeacherYun",dataProviderClass = DataProvid.class)
    public void selectClassTest(String username, String pwd) throws Exception {
        loginPage = new LoginPage(username,pwd,driver);
        Thread.sleep(2000);
        loginPage.loginSuccess();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(3000);
        switchLoginPageYindaoImage = new SwitchLoginPageYindaoImage(driver);
        switchLoginPageYindaoImage.switchYindaoImage();
        selectClassMode =new SelectClassMode(driver);
        selectClassMode.selectClass();
        selectClassMode.selectClassMode("shangke");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals("在线学生",driver.findElement(By.id("com.etiantian.pclass:id/lfsc_txt_title")).getText());
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
