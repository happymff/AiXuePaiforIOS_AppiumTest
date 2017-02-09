package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class SwitchRecordCompleteYindaoImage {
    AndroidDriver driver ;

    public SwitchRecordCompleteYindaoImage(AndroidDriver driver){
        this.driver = driver;
    }
    public void switchRecordCompleteYindaoImage(){
        driver.findElement(By.id("com.etiantian.pclass:id/ydt_save_over")).click();
    }
}
