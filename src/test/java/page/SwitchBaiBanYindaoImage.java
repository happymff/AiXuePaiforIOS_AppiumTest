package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class SwitchBaiBanYindaoImage {
    AndroidDriver driver ;

    public SwitchBaiBanYindaoImage(AndroidDriver driver){
        this.driver = driver;
    }
    public void switchBaibanYindaoImage(){
        driver.findElement(By.id("com.etiantian.pclass:id/ydt_shape_over")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/ydt_txt_over")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/ydt_record_over")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/ydt_stop_over")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/ydt_fbtn_over")).click();
    }
}
