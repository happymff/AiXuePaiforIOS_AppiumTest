package page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class SwitchLoginPageYindaoImage {
    AndroidDriver driver ;

    public SwitchLoginPageYindaoImage(AndroidDriver driver){
        this.driver = driver;
    }
    public void switchYindaoImage(){
        driver.findElement(By.id("com.etiantian.pclass:id/ydt_part_over")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/ydt_enter_over")).click();
    }
}
