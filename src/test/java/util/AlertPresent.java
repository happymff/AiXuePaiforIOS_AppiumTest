package util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

/**
 * Created by mengfeifei on 2017/1/3.
 */
public class AlertPresent {

    public boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String GetItsText(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            return alertText;
        } catch (NoAlertPresentException e) {
            return "No Such Alert Present";
        }
    }
    public void acceptAlert(WebDriver driver, Boolean accept) {
        try {
            Alert alert = driver.switchTo().alert();
            if (accept==true) {
                alert.accept();
            }else {
                alert.dismiss();
            }
        } catch (NoAlertPresentException e) {
            System.out.println("没有Alert");
        }
    }
}