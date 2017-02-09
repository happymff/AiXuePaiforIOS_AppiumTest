package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class FileFolder {
    AndroidDriver driver ;

    public FileFolder(AndroidDriver driver){
        this.driver = driver;
    }
    public void goIntoFileFolder(){
        driver.findElement(By.id("com.etiantian.pclass:id/lftm_btn_folder")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/ligf_card")).click();
    }
    public void returnFileFolder(){
        driver.findElement(By.id("com.etiantian.pclass:id/lfmf_btn_back")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/lfmf_btn_back")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
