package util;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.IOException;


/**
 * Created by mff on 2017/5/11.
 */
public class ScreenshotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) throws NullPointerException{
        AppiumDriver driver = Screenshot.getDriver();
        final File classpathRoot = new File(System.getProperty("user.dir"));
        final File location = new File(classpathRoot, "src/test/resource/screenshots");
        //File location = new File("screenshots"); //在默认的工作目录下面创建一个名字叫screenshots的文件夹，用来存放图片的
        String screenShotName = location.getAbsolutePath()+File.separator+tr.getMethod().getMethodName()+".png"; //
        File screenShot = driver.getScreenshotAs(OutputType.FILE);
        try{
           FileUtils.copyFile(screenShot, new File(screenShotName));
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
