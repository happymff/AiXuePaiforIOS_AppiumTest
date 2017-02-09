package page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class SelectClassMode {
    AndroidDriver driver ;

    public SelectClassMode(AndroidDriver driver){
        this.driver = driver;
    }
    public void selectClassMode(String mode){
       if ("Shangke".equals(mode)){
           driver.findElement(By.id("com.etiantian.pclass:id/lacc_btn_enter")).click();
       } else{
           driver.findElement(By.id("com.etiantian.pclass:id/lacc_btn_ready")).click();
       }

    }
}
