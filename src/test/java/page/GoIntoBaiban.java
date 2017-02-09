package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class GoIntoBaiban {
    AndroidDriver driver ;

    public GoIntoBaiban(AndroidDriver driver){
        this.driver = driver;
    }
    public void goIntoBaiBan(){
        driver.findElement(By.id("com.etiantian.pclass:id/lag_tag_wboard_img")).click();
    }
}
