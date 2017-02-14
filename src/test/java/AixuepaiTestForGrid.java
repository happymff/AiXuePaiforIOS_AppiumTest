import appium.AppiumDriverBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class AixuepaiTestForGrid {

    protected AndroidDriver driver;
    protected AndroidDriver driver2;
    protected WebDriverWait wait;
    String platformName ="ANDROID";
    String apkname="app-aixuepai.apk";
    String devicename="7LBEAMG699999999";
    String udid = "7LBEAMG699999999";
    String platormVersion="5.0.1";
    String devicename2="192.168.56.101:5555";
    String platormVersion2="5.1";
    String udid2 = "192.168.56.101:5555";

    @BeforeMethod
    public void setUp() throws Exception {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/test/resource/apps/");
        File app = new File(appDir,apkname);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName",platformName);
        capabilities.setCapability("deviceName", devicename);
        capabilities.setCapability("platformVersion",platormVersion);
        capabilities.setCapability("udid",udid);
        //support Chinese
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.etiantian.pclass");
        //capabilities.setCapability("appActivity", "com.etiantian.pclass.page.activities.LoadingActivity");
        // initializing driver object
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);


        File classpathRoot2 = new File(System.getProperty("user.dir"));
        File appDir2 = new File(classpathRoot2, "src/test/resource/apps/");
        File app2 = new File(appDir2,apkname);
        DesiredCapabilities capabilities2 = new DesiredCapabilities();
        capabilities2.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities2.setCapability("platformName",platformName);
        capabilities2.setCapability("deviceName", devicename2);
        capabilities2.setCapability("platformVersion",platormVersion2);
        capabilities2.setCapability("udid",udid2);
        //support Chinese
        capabilities2.setCapability("unicodeKeyboard", "True");
        capabilities2.setCapability("resetKeyboard", "True");
        capabilities2.setCapability("app", app2.getAbsolutePath());
        capabilities2.setCapability("appPackage", "com.etiantian.pclass");
        capabilities2.setCapability("appActivity", "com.etiantian.pclass.page.activities.LoadingActivity");

        // initializing driver object
        driver2 = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities2);
// initializing explicit wait object
        driver2.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wait = new WebDriverWait(driver2, 10);

   }
    @Test
    public void loginTest1() throws Exception {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        System.out.println(width);
        System.out.println(height);

        for (int j = 0; j < 3; j++) {
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            TouchAction dragNDrop = new TouchAction(driver);
            dragNDrop.longPress(width * 14 / 15, height / 2).moveTo(width / 15, height / 2).release().perform();
            }

        driver.findElement(By.id("com.etiantian.pclass:id/go_bt")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement ae1 = driver.findElement(By.id("com.etiantian.pclass:id/lag_ed_name"));
        //ae1.click();
        //ae1.clear();
        ae1.sendKeys("爱学派D");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement ae2 = driver.findElement(By.id("com.etiantian.pclass:id/lag_ed_pwd"));
        //ae2.click();
       // ae2.clear();
        ae2.sendKeys("a11111");
        driver.findElement(By.id("com.etiantian.pclass:id/lag_btn_login")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String selectClass = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals("选择班级", selectClass);

        driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        int width2 = driver2.manage().window().getSize().width;
        int height2 = driver2.manage().window().getSize().height;
        System.out.println(width2);
        System.out.println(height2);

        for (int i = 0; i < 3; i++) {
            // perform Drag and Drop
            Thread.sleep(3000);
            driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            TouchAction dragNDrop2 = new TouchAction(driver2);
            dragNDrop2.longPress(width * 14 / 15, height / 2).moveTo(width / 15, height / 2).release().perform();
        }

    }

    @AfterMethod
    public void closeDriver() throws Exception {
        driver.quit();
    }
}