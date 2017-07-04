package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by mengfeifei on 2017/5/24.
 */
public class InitSetup {

    public DesiredCapabilities InitSetUpCFG(final DesiredCapabilities capabilities) throws MalformedURLException,IOException{

        //setup appium
        if (Config.CONFIG_FILE.equals("src/android_config.properties")){
            //对配置文件进行判断，如果android_config.properties,则读取Android配置信息，默认为Android
            final File appDir = new File(System.getProperty("user.dir"),"app");
            final File app = new File(appDir,Config.getInstance().getCfg("appDir"));
            capabilities.setCapability("app",Config.getInstance().getCfg("app"));
            //设置App所在路径
            capabilities.setCapability(CapabilityType.BROWSER_NAME,"");
            capabilities.setCapability("platformVersion",Config.getInstance().getCfg("platformVersion"));
            //设置Android版本
            capabilities.setCapability("platformName",Config.getInstance().getCfg("platformName"));
            //设置Android系统
            capabilities.setCapability("deviceName",Config.getInstance().getCfg("deviceName"));
            //设置Android手机的名称
            capabilities.setCapability("appPackage",Config.getInstance().getCfg("appPackage"));
            //设置App包名
            capabilities.setCapability("appActivity",Config.getInstance().getCfg("appActivity"));
            //设置App入口Activity
            capabilities.setCapability("unicodeKeyboard",Config.getInstance().getCfg("unicodeKeyboard"));
            //设置中文输入法
            capabilities.setCapability("resetKeyboard",Config.getInstance().getCfg("resetKeyboard"));
            //重置Appium为默念输入法
            capabilities.setCapability("newCommandTimeout",Config.getInstance().getCfg("newCommandTimeout"));
            //设置Appium命令超时时间
        }else if (Config.CONFIG_FILE.equals("src/ios_config.properties")){
            //对配置文件进行判断，如果android_config.properties,则读取Android配置信息，默认为Android
            final File appDir = new File(System.getProperty("user.dir"),Config.getInstance().getCfg("appDir"));
            final File app = new File(appDir,Config.getInstance().getCfg("app"));
            capabilities.setCapability("app",app.getAbsolutePath());
            //设置App所在路径
            capabilities.setCapability(CapabilityType.BROWSER_NAME,"");
            capabilities.setCapability("platformVersion",Config.getInstance().getCfg("platformVersion"));
            //设置ios版本
            capabilities.setCapability("automationName",Config.getInstance().getCfg("automationName"));
            //设置测试方法
            capabilities.setCapability("autoAcceptAlerts",Config.getInstance().getCfg("autoAcceptAlerts"));
            //设置测试方法
            capabilities.setCapability("platformName",Config.getInstance().getCfg("platformName"));
            //设置ios系统
            capabilities.setCapability("deviceName",Config.getInstance().getCfg("deviceName"));
            //设置ios手机的名称
            capabilities.setCapability("bundleId",Config.getInstance().getCfg("bundleId"));
            //设置App包名
            capabilities.setCapability("udid",Config.getInstance().getCfg("udid"));
            //设置ios手机的udid
            capabilities.setCapability("unicodeKeyboard",Config.getInstance().getCfg("unicodeKeyboard"));
            //设置中文输入法
            capabilities.setCapability("resetKeyboard",Config.getInstance().getCfg("resetKeyboard"));
            //重置Appium为默念输入法
            capabilities.setCapability("newCommandTimeout",Config.getInstance().getCfg("newCommandTimeout"));
            //设置Appium命令超时时间
            capabilities.setCapability("fullReset",Config.getInstance().getCfg("fullReset"));
            //设置Appium命令超时时间
        }
        return capabilities;
    }
    public void TearDownCFG(AppiumDriver driver) throws MalformedURLException{
        driver.quit();
    }

}
