package appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.junit.Assert.*;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestForJiangjiu extends DriverBase{
    //Test Annotation changes any java function to TestNG test case
    @Test
    public void sampeTest() throws MalformedURLException, InterruptedException {
//click on Accessibility link
        //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility")));

        //          driver.findElement(By.id("com.bbk.launcher2:id/item_icon")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        // find keyword 首页 and verify it is display

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        System.out.println(width);
        System.out.println(height);

       for(int i = 0; i< 4; i++) {
        // perform Drag and Drop
         TouchAction dragNDrop = new TouchAction(driver);
           dragNDrop.longPress(width*14/15,height/2).moveTo(width/15,height/2).release().perform();

        }
        TouchAction dragNDrop1 = new TouchAction(driver);
        WebElement w1 =driver.findElement(By.id("com.moft:id/viewpager"));
        dragNDrop1.longPress(w1,100,100).moveTo(200,300).release().perform();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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