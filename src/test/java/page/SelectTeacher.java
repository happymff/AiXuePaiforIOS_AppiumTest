package page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class SelectTeacher {
    AndroidDriver driver;

    public SelectTeacher(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectTeacher() {

        driver.findElement(By.id("com.etiantian.pclass:id/ligt_btn")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/laf_btn_enter")).click();

    }
}
