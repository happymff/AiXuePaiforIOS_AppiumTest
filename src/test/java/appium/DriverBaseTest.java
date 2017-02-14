package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.AppiumServer;

import java.io.File;
import java.net.URL;

public class DriverBaseTest {
    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/test/resource/apps/");
        File app = new File(appDir, "ContactManager.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "192.168.56.101:5555");
        capabilities.setCapability("platformVersion", "5.1");
        //if no need install don't add this
        capabilities.setCapability("app", app.getAbsolutePath());
        //capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        //support Chinese
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
        //start
        //capabilities.setCapability("appActivity", "com.moft.gotoneshopping.activity.WelcomeActivity");
        AppiumServer AS = new AppiumServer();
        AS.runServer(4723,"192.168.56.101:5555");
        //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}