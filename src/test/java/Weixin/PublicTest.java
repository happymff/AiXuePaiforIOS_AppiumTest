package Weixin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * Created by mengfeifei on 2017/1/16.
 */
public class PublicTest extends DriverForPublic{
    @Test
    public void publicProgramTest() throws Exception {

        driver.findElementByXPath("//*[@text='龙之门大语文']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='家长']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='精彩阅读']").click();
        Thread.sleep(3000);
        Set<String> contextNames = driver.getContextHandles();
        Thread.sleep(1000);
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.tencent.mm:tools");
        Thread.sleep(1000);
        System.out.println("已经进入WEBVIEW啦");
        //System.out.println(driver.getPageSource());
        String s1 = driver.getWindowHandle();
        System.out.println(s1);
        // WebElement w1 = driver.findElement(By.id("namespace_0")).findElement(By.className("desc js_title"));
        // WebElement w1 =  driver.findElementByXPath("//*[contains(@url, '大语文的春天')]");
        WebElement w1 = driver.findElementByXPath("//*[@id=\"namespace_0\"]/div[1]/div[1]/a/p");
        String s2 = w1.getText();
        if ("大语文的春天".equals(s2)) {
            w1.click();
        }
        Thread.sleep(3000);
        Set<String> set1 = driver.getWindowHandles();
        System.out.println(set1);

//        for (String windows : set1) {
//            System.out.println(windows);
////            if (windows.equalsIgnoreCase(s1)) {
////
////            } else {
////                driver.switchTo().window(windows);
////            }
//        }
//        WebElement w2 = driver.findElementByXPath("//*[@id=\"activity-name\"]");
//        String s3 = w2.getText();
//        System.out.println(s3);
//        Assert.assertTrue(s3.contains("大语文的春天"));
    }



}
