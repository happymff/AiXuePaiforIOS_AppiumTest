package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class RecordAndPause {
    AndroidDriver driver ;

    public RecordAndPause(AndroidDriver driver){
        this.driver = driver;
    }
    public void record(){
        driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_record")).click();
    }
    public void pause(){
        driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_stop_record")).click();
    }
}
