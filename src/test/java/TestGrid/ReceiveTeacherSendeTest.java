package TestGrid;

import DataProvider.DataProvid;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPageForStudent;
import page.ReceiveTeacherSend;
import page.SelectTeacher;
import page.SwitchLoginPageYindaoImage;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class ReceiveTeacherSendeTest {
    AndroidDriver driver;
    InitializeDriver1 initialize;
    ReceiveTeacherSend receive;
    SelectTeacher selectTeacher;
    @BeforeMethod
    public  void setUp() throws  Exception {
        initialize = new InitializeDriver1("7LBEAMG699999999","5.0.1");
        // initializing driver object
        // DesiredCapabilities caps =initialize.driverInitialize();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"), initialize.driverInitialize());
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void receiveTeacherTest() throws Exception {
        Thread.sleep(2000);
        selectTeacher = new SelectTeacher(driver);
        selectTeacher.selectTeacher();
        Thread.sleep(2000);
        receive = new ReceiveTeacherSend(driver);
        String sendfilename = receive.receiveTeacherSends().getText();
        Assert.assertEquals("名词性从句",sendfilename);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
