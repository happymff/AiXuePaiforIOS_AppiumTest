package iosTest;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.IsElementPresent;

import java.net.URL;
import java.util.Random;
import util.InitializeDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class TeacherLoginTest1 {
    IOSDriver driverios, driverios2;
    InitializeDriver initialize;

    @BeforeMethod
    public void setUp() throws Exception {

        initialize = new InitializeDriver();
        // initializing driver object
        driverios = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize("10.1", "iPad mini4", "bfb13a751d799eb97d37dce5e398fe16c5c3fd44"));
       // driverios = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize("9.3","iPad mini2","4d5a7ada1f9f8025019021777679610424440b68"));
        driverios.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void pushTest() throws Exception {
        int width = driverios.manage().window().getSize().width;
        int height = driverios.manage().window().getSize().height;
        System.out.println(width);
        System.out.println(height);
        for (int i = 0; i < 3; i++) {
            driverios.swipe(width * 6 / 7, height / 2, width * 2 / 7, 0, 1000);
        }
        System.out.println("滑动成功");

        //点击登录按钮
        driverios.findElement(By.className("UIAButton")).click();
        Thread.sleep(2000);
        System.out.println("点击立即登录按钮成功");

        //输入账号和密码
        driverios.findElement(By.className("UIATextField")).sendKeys("爱学派FF");
        driverios.tap(1, width * 2 / 3, height * 1 / 5, 500);
        //driverios.hideKeyboard();
        //driverios.findElementByAccessibilityId("隐藏键盘").click();
        driverios.findElement(By.className("UIASecureTextField")).sendKeys("a11111");
        driverios.tap(1, width * 2 / 3, height * 1 / 5, 500);
        driverios.findElement(By.id("登录")).click();
        System.out.println("登录成功");
        //教师选择班级
        driverios.findElement(By.id("高二爱学派CS二班")).click();
        driverios.findElement(By.id("高二爱学派CS一班")).click();
        driverios.findElement(By.id("进入课堂")).click();
        System.out.println("进入课堂成功");
        Thread.sleep(2000);
        //菜单切换
        //点击菜单按钮
        //driverios.findElement(By.id("navbar menu default")).click();
        driverios.findElementByAccessibilityId("navbar menu default").click();
        Thread.sleep(3000);
        //driverios.findElement(By.id("我的课程")).click();
        driverios.findElementByAccessibilityId("我的课程").click();
        driverios.findElementByAccessibilityId("navbar menu default").click();
        for (int i = 0; i < 1000; i++) {
            driverios.findElement(By.id("(2)")).click();
            driverios.findElement(By.id("总复习：现代诗、散文标准测试B")).click();
            System.out.println(driverios.getContextHandles());

            System.out.println("~~~~~~~~~~~~~~~~~~~~~第" + (i + 1) + "次推送~~~~~~~~~~~~~~~~~~~~~~~~~");
            //driverios.findElement(By.id("推题")).click();
            driverios.findElement(By.id("推试卷")).click();
            //Thread.sleep(5000);
            IsElementPresent isElementPresent = new IsElementPresent();
//                if ((isElementPresent.isElementPresent(By.id("1.　　阅读艾青的《镜子》，指出对其风格评论不准确的一项(　　)"), driverios)) && (isElementPresent.isElementPresent(By.id("结束作答"), driverios))) {
//                    System.out.println("推送试题1成功");
//                } else {
//                    System.out.println("出错了~~~~");
//                }
            //String s1 = driverios.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div[71]")).getText();
            //System.out.println(s1);
            //System.out.println(driverios.getContextHandles());
            Thread.sleep(2000);
            driverios.findElement(By.id("结束作答")).click();
            Thread.sleep(2000);
            if (isElementPresent.isElementPresent(By.id("已公布答案"), driverios)) {
                System.out.println("结束作答~~");
            } else {
                System.out.println("出错了~~~~");
            }
            driverios.findElement(By.id("结束推送")).click();
            if (isElementPresent.isElementPresent(By.id("推试卷"), driverios)) {
                System.out.println("结束推送啦~~");
            } else {
                System.out.println("出错了~~~~");
            }
            driverios.findElement(By.id("返回")).click();
            driverios.findElement(By.id("返回")).click();

            //System.out.println("~~~~~~~~~~~~~~第" + (i + 1) + "次~~~~~~~~~~~~~~~~~~~~~~");
            Thread.sleep(5000);//课程刷新
            driverios.findElement(By.id("总复习：现代诗、散文")).click();
            System.out.println("进入 总复习：现代诗、散文的课程");
            Thread.sleep(5000);//课件刷新
            //判断是否已下载
            if (i == 0) {
                driverios.findElement(By.id("自动化测试需要")).click();
                System.out.println("下载课件 自动化测试需要pdf");
                Thread.sleep(10000);//下载课件时间
            }
            driverios.findElement(By.id("自动化测试需要")).click();
            System.out.println("打开课件 自动化测试需要pdf");
            Thread.sleep(5000);//打开课件时间
            //点击课件推送按钮
            driverios.findElement(By.id("推送")).click();
            System.out.println("正在推送中");
            Thread.sleep(5000);
            driverios.tap(1, width / 2, height / 2, 500); //fingers 手指数量
            System.out.println("点击屏幕成功");
            int width1 = driverios.manage().window().getSize().width;
            int height1 = driverios.manage().window().getSize().height;
            Random r1 = new Random();
            int count1 = r1.nextInt(10);
            System.out.println("向上滑动的次数：" + count1);
            for (int j = 0; j < count1; j++) {
                driverios.swipe(width1 / 2, height1 * 8 / 10, width1 / 2, height1 * 1 / 10, 1000);
                System.out.println("向上滑动成功");
            }
            Random r2 = new Random();
            int count2 = r2.nextInt(5);
            System.out.println("向下滑动的次数：" + count2);
            for (int k = 0; k < count2; k++) {
                driverios.swipe(width1 / 2, height1 * 2 / 10, width1 / 2, height1 * 9 / 10, 1000);
                System.out.println("向下滑动成功");
            }
            driverios.tap(1, width1 / 2, height1 / 2, 500); //fingers 手指数量
            System.out.println("点击屏幕成功");
            Thread.sleep(1000);
            driverios.findElement(By.id("结束推送")).click();
            System.out.println("点击结束推送课件成功");
            driverios.findElement(By.id("返回")).click();
            System.out.println("点击返回成功");
            driverios.findElement(By.id("返回")).click();
            System.out.println("返回到我的课程页");
        }
    }


    @AfterMethod
    public void tearDown() {
        driverios.resetApp();
        driverios.quit();
    }
}
