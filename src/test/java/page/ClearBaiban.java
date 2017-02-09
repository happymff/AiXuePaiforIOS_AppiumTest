package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class ClearBaiban {
    AndroidDriver driver ;

    public ClearBaiban(AndroidDriver driver){
        this.driver = driver;
    }
    public void clearBaiBan(){
        driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_clear")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/negativeButton")).click();
    }
}
