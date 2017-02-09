package AiXuepai;

import DataProvider.DataProvid;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.SelectClass;
import page.SwitchLoginPageYindaoImage;
import util.Initialize;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class SelectClassTest {
    AndroidDriver driver;
    Initialize initialize;
    LoginPage loginPage;
    SwitchLoginPageYindaoImage switchLoginPageYindaoImage;
    SelectClass selectClass;
    @BeforeMethod
    public  void setUp() throws  Exception {
       initialize = new Initialize();
        // initializing driver object
       // DesiredCapabilities caps =initialize.driverInitialize();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize());
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }


    @Test(description = "登陆成功",dataProvider = "LoginSucess",dataProviderClass = DataProvid.class)
    public void selectClassTest(String username, String pwd) throws Exception {
        loginPage = new LoginPage(username,pwd,driver);
        Thread.sleep(2000);
        loginPage.loginSuccess();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(3000);
        switchLoginPageYindaoImage = new SwitchLoginPageYindaoImage(driver);
        switchLoginPageYindaoImage.switchYindaoImage();
        selectClass =new SelectClass(driver);
        selectClass.selectClass();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals("高二英语",driver.findElement(By.id("com.etiantian.pclass:id/lftc_txt_title")).getText());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
