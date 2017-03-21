package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class ReceiveTeacherSend {
    AndroidDriver driver;

    public ReceiveTeacherSend(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement receiveTeacherSends() throws InterruptedException {

        WebElement webElement = driver.findElement(By.id("com.etiantian.pclass:id/lap_txt_title"));
        return webElement;
    }
}
