package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class TestForJiangjiuofLogin extends DriverBase{
    //Test Annotation changes any java function to TestNG test case
    @Test
    public void sampeTest() throws MalformedURLException, InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.moft:id/buttom_four")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(MobileBy. AndroidUIAutomator ("text(\"登录\")")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(MobileBy. AndroidUIAutomator ("text(\"登  录\")")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement ae =driver.findElement(By.id("com.moft:id/account_name"));
        Assert.assertEquals("zhanghan",ae.getText());
    }
}