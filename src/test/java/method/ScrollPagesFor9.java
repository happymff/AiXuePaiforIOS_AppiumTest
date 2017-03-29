package method;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.concurrent.TimeUnit;

/**
 * 滑动屏幕
 * Created by mff on 2017/3/28.
 */
public class ScrollPagesFor9 {

    //获取屏幕的大小
    public void getScreenSize(IOSDriver iosDriver) {
        int width = iosDriver.manage().window().getSize().width;
        int height = iosDriver.manage().window().getSize().height;
        System.out.println("屏幕宽度：" + width);
        System.out.println("屏幕长度：" + height);
    }

    //从右向左滑动
    public void scrollRightToLeft(IOSDriver driver, int i, int width, int height) throws Exception {
        driver.swipe(width / 2, height * 1 / 7, width / 2, height * 6 / 7, 10);
        System.out.println("~~~~第" + i + "次滑动成功~~~~");
    }

    //从左向右滑动
    public void scrolleftToRight(IOSDriver iosDriver, int i, int width, int height) {
        iosDriver.swipe(width / 2, height * 6 / 7, width / 2, height * 1 / 7, 10);
        System.out.println("~~~~第" + i + "次滑动成功~~~~");
    }

    //从下向上滑动
    public void scrollUpToDown(IOSDriver iosDriver, int i, int width, int height) {
        iosDriver.swipe(width * 6 / 7, height / 2, width * 1 / 7, height / 2, 1000);
        System.out.println("~~~~第" + i + "次滑动成功~~~~");
    }

    //从上向下滑动
    public void scrollDownToUp(IOSDriver iosDriver, int i, int width, int height) {
        iosDriver.swipe(width * 1 / 7, height / 2, width * 6 / 7, height / 2, 1000);
        System.out.println("~~~~第" + i + "次滑动成功~~~~");
    }
}

