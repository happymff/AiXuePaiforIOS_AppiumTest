package page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class LookAtKejian {
    AndroidDriver driver;

    public LookAtKejian(AndroidDriver driver) {
        this.driver = driver;
    }

    public void lookAtKejian(int num) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        for (int i = 0; i < num; i++) {
            // perform Drag and Drop
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            TouchAction dragNDrop = new TouchAction(driver);
            dragNDrop.longPress(width  / 2, height *6 / 7).moveTo(width / 2, height / 7).release().perform();
        }


    }
}