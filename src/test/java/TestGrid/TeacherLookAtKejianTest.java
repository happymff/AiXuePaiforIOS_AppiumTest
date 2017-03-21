package TestGrid;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class TeacherLookAtKejianTest {
    AndroidDriver driver;
    InitializeDriver initialize;
    LookAtKejian lookAtKejian;
    @BeforeMethod
    public  void setUp() throws  Exception {
        initialize = new InitializeDriver("192.168.56.101:5555","5.1");
        // initializing driver object
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize());
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void selectClassTest() throws Exception {
        Thread.sleep(2000);
        String snum = driver.findElement(By.id("<class name=\"TestGrid.ReceiveTeacherSendeTest\"/>")).getText();
        // num = SubString(snum);
        lookAtKejian = new LookAtKejian(driver);
        lookAtKejian.lookAtKejian(1);
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
