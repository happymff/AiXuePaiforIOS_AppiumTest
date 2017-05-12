package method;

import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by mff on 2017/5/12.
 */
public class ScreenShot {

    public IOSDriver driver;

    public ScreenShot(IOSDriver driver) {
        this.driver = driver;
    }

    private void takeScreenshot(String screenPath) throws IOException {
        try {
            System.out.println("截图");
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenPath));
        } catch (IOException e) {
            System.out.println("Screen shot error: " + screenPath);
            //Reporter.log("该错误可以查看截图："+screenPath);
        }
    }

    public void takeScreenshot() throws IOException {
        System.out.println("截图啦~~~");
        String screenName = String.valueOf(new Date().getTime()) + ".jpg";
        File classpathRoot = new File(System.getProperty("user.dir"));
        File dir = new File(classpathRoot, "src/test-output/screenshots");
        if (!dir.exists())
            dir.mkdirs();
        String screenPath = dir.getAbsolutePath() + "/" + screenName;
        System.out.println(screenName);
        this.takeScreenshot(screenPath);
    }
}
