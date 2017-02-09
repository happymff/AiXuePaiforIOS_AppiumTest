package util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
/**
 * Created by mengfeifei on 2017/1/3.
 */
public class IsElementPresent {

    public boolean isElementPresent(By by, AndroidDriver driver) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
