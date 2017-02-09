package Weixin;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * Created by mengfeifei on 2017/1/16.
 */
public class PublicTest2 extends DriverForPublic{
    @Test
    public void publicProgramTest() throws Exception {
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='通讯录']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='公众号']").click();
        Thread.sleep(2000);
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        for (int i = 0; i < 100; i++) {
            if(driver.getPageSource().contains("北京超市发")){
                break;
            }
            // perform Drag and Drop
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            TouchAction dragNDrop = new TouchAction(driver);
            dragNDrop.longPress(width  / 2, height *14/ 15).moveTo(width / 2, height / 15).release().perform();

        }
        driver.findElementByXPath("//*[@text='北京超市发']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='最新优惠']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='热门活动']").click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        Set<String> contextNames = driver.getContextHandles();
        Thread.sleep(1000);
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.tencent.mm:tools");
        Thread.sleep(1000);
        System.out.println("已经进入WEBVIEW啦");
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());
        String s1 = driver.getWindowHandle();
        System.out.println(s1);
        WebElement w1 = driver.findElementByXPath("/html/body/div/div/a");
        String s2 = w1.getText();
        if ("前往会员主页".equals(s2)) {
            w1.click();
        }
        Thread.sleep(10000);
        System.out.println(driver.getCurrentUrl());
//        Set<String> set1 = driver.getWindowHandles();
//        System.out.println(set1);
//        try{
//            Set<String> windows=driver.getWindowHandles();
//            driver.switchTo().window((String) windows.toArray()[windows.size()-1]);
//        }catch (Exception e){
//            System.out.println("Try to switch windows fails");
//
//        }
        WebElement w2 = driver.findElementByXPath("//*[@text='全部订单']");
        w2.click();
    }



}
