package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class Upload {
    AndroidDriver driver ;

    public Upload(AndroidDriver driver){
        this.driver = driver;
    }
    public void upload(){
        driver.findElement(By.id("com.etiantian.pclass:id/btn_upload")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/positiveButton")).click();
    }
}
