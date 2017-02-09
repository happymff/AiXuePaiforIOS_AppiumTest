package page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class PreviewAndSaveRecording {
    AndroidDriver driver ;

    public PreviewAndSaveRecording(AndroidDriver driver){
        this.driver = driver;
    }
    public void previewRecording(){
        //开始播放
        driver.findElement(By.id("com.etiantian.pclass:id/start_bt")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //点击一下播放的页面
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(driver.findElement(By.id("com.etiantian.pclass:id/videoview"))).release().perform();
    }
    public void saveRecording(String recordName){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //点击保存按钮
        driver.findElement(By.id("com.etiantian.pclass:id/lar_btn_save")).click();
        //输入保存的名称
        driver.findElement(By.id("com.etiantian.pclass:id/dialog_edit")).sendKeys(recordName);
        //点击确定按钮
        driver.findElement(By.id("com.etiantian.pclass:id/enterBtn")).click();
    }
}
