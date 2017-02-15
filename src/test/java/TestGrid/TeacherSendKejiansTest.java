package TestGrid;

import DataProvider.DataProvid;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.PushKejian;
import page.SelectClassMode;
import page.SwitchLoginPageYindaoImage;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class TeacherSendKejiansTest {
    AndroidDriver driver;
    InitializeDriver initialize;
    LoginPage loginPage;
    SwitchLoginPageYindaoImage switchLoginPageYindaoImage;
    SelectClassMode selectClassMode;
    PushKejian pushKejian;
    @BeforeMethod
    public  void setUp() throws  Exception {
        initialize = new InitializeDriver("192.168.56.101:5555","5.1");
        // initializing driver object
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize());
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void sendKejianTest() throws Exception {
        Thread.sleep(2000);
        pushKejian = new PushKejian(driver);
        pushKejian.enterKechengList();
        Thread.sleep(2000);
        List<WebElement> webElementList = driver.findElement(By.id("com.etiantian.pclass:id/lftc_rlv")).findElements(By.className("android.widget.RelativeLayout"));
       // System.out.println(webElementList.size());
        //webElementList.get(0).click();
        Assert.assertEquals("总复习：表语从句、同位语...",webElementList.get(0).findElement(By.id("com.etiantian.pclass:id/ligc_txt_course")).getText());

        pushKejian.enterKejianList();
        List<WebElement> webElementList1 = driver.findElements(By.id("com.etiantian.pclass:id/ligcw_base"));
        Assert.assertEquals("名词性从句",webElementList1.get(0).findElement(By.id("com.etiantian.pclass:id/ligcw_txt_ware")).getText());
        pushKejian.enterKejianDetail();
        //Thread.sleep(2000);
        pushKejian.pushKejian();
        //Thread.sleep(2000);
        String pushState =  driver.findElement(By.id("com.etiantian.pclass:id/ilpp_btn_push")).getText();
        Assert.assertEquals("结束推送",pushState);
       //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
