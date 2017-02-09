package Weixin;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ReadExcelPOI;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * Created by mengfeifei on 2017/1/16.
 */
public class MiniProgramTest extends Driver{
    @Test
    public void miniProgramTest() throws Exception {

       // println(driver.getPageSource)
        driver.findElementByXPath("//*[@text='发现']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='小程序']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[contains(@text, 'QQ阅读')]").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//*[@text='书库']").click();
        Set<String> contextNames = driver.getContextHandles();
        Thread.sleep(1000);
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.tencent.mm:tools");
        Thread.sleep(3000);
        System.out.println("已经进入WEBVIEW啦");
        //System.out.println(driver.getPageSource());
        String s1 = driver.getWindowHandle();

        driver.findElementByXPath("//*[contains(@url, '古代')]").click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Set<String> set1 = driver.getWindowHandles();
        System.out.println(set1);
        for(String windows: set1){
            if (windows.equalsIgnoreCase(s1)){

            }else{
                driver.switchTo().window(windows);
            }
        }
        //driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        Thread.sleep(2000);
        driver.findElementByXPath("//*[contains(@url, 'bid=716295')]").click();
        String s2 = driver.findElementByXPath("//*[contains(@url, 'bid=716295')]").getText();
        System.out.println(s2);
        Assert.assertTrue(s2.contains("美人榻"));
        Thread.sleep(3000);
        driver.context("NATIVE_APP");
        System.out.println("已经回到NativeAPP啦");
        driver.findElementById("com.tencent.mm:id/io").click();
        //driver.findElement(By.id("com.tencent.mm:id/io")).click();
        }




}
