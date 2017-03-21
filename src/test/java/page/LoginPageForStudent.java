package page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class LoginPageForStudent {
    AndroidDriver driver ;
    String username;
    String pwd;
    public LoginPageForStudent(String username, String pwd, AndroidDriver driver){
        this.username = username;
        this.pwd = pwd;
        this.driver = driver;
    }
    public void studentLogin() throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        for (int i = 0; i < 3; i++) {
            // perform Drag and Drop
            TouchAction dragNDrop = new TouchAction(driver);
            dragNDrop.longPress(width * 14 / 15, height / 2).moveTo(width / 15, height / 2).release().perform();
            Thread.sleep(500);
        }
        driver.findElement(By.id("com.etiantian.pclass:id/go_bt")).click();
        WebElement ae1 = driver.findElement(By.id("com.etiantian.pclass:id/lag_ed_name"));
        //输入用户名
        ae1.sendKeys(username);
        WebElement ae2 = driver.findElement(By.id("com.etiantian.pclass:id/lag_ed_pwd"));
        //输入密码
        ae2.sendKeys(pwd);
        //点击登录
        driver.findElement(By.id("com.etiantian.pclass:id/lag_btn_login")).click();

    }
}
