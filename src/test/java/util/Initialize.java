package util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;


public class Initialize {

    String platformName = "ANDROID";
    String apkname = "app-aixuepai.apk";
    String devicename = "192.168.56.101:5555";
    String platormVersion = "5.1";
    Boolean install = false;

    public DesiredCapabilities driverInitialize() throws Exception {
        // set up appium

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/test/resource/apps/");
        File app = new File(appDir, apkname);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //设置每次运行不重新启动被测试app
        //capabilities.setCapability("noReset","true");
        //capabilities.setCapability("fullReset","false");

        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", devicename);
        capabilities.setCapability("platformVersion", platormVersion);
        //support Chinese
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");

       // if (install == true) {
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("appPackage", "com.etiantian.pclass");
      // }
        return capabilities;
    }
}
