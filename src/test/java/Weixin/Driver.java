package Weixin;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    //public ChromeDriverHandles chromeDriverHandles;
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    // before Test Annotation makes a java function to run every time before a TestNG test case
    @BeforeTest
    protected void setDriver() throws
            MalformedURLException, InterruptedException {



// setting up desired capability
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "ANDROID");
        caps.setCapability("platformVersion", "5.1.1");
       // caps.setCapability("automationName","uiautomator2");
        caps.setCapability("deviceName", "A02AECPB2CLTG");
        caps.setCapability("browserName", "");
        caps.setCapability("app", "");
        //caps.setCapability("autoWebview", "true");
        //caps.setCapability("autoWebviewTimeout","3000");
        caps.setCapability("appPackage", "com.tencent.mm");
        caps.setCapability("appActivity", ".ui.LauncherUI");
        caps.setCapability("fastReset", "false");
        caps.setCapability("fullReset", "false");
        caps.setCapability("noReset", "true");
        //设置输入法
        //caps.setCapability("unicodeKeyboard", "True");
        //隐藏键盘
       // caps.setCapability("resetKeyboard", "True");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("androidProcess", "com.tencent.mm:appbrand1");
        caps.setCapability(ChromeOptions.CAPABILITY, options);
// initializing driver object
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
       // ChromedriverHandler.chromeDriverHandlerThread().start();
    }
    // After Test Annotation makes a java function to run every time after a TestNG test case
    @AfterTest
    public void afterTest() {
       // quit the driver
        driver.quit();

    }

}