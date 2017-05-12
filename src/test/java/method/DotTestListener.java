package method;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import iosTest.LoginTest1;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

/**
 * Created by mff on 2017/5/12.
 */
public class DotTestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        try {
            LoginTest1 tb = (LoginTest1) tr.getInstance();
            IOSDriver driver = tb.getDriver();
            ScreenShot screenShot = new ScreenShot(driver);
            screenShot.takeScreenshot();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}