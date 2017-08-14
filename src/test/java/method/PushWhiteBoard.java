package method;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import page.teacherpage.*;
import util.IsElementPresent;

/**
 * 滑动屏幕
 * Created by mff on 2017/3/28.
 */
public class PushWhiteBoard {
    NavigationPage nav;
    WhiteBoardPage whiteBoardPage;

    //推送课件
    public void pushWhiteBoard(IOSDriver driver) throws InterruptedException {
        nav = new NavigationPage(driver);
        System.out.println(driver.findElementsByAccessibilityId("电子白板").size());
        nav.navBar.click();
        Thread.sleep(3000);
        nav.whiteBoard.click();
        Thread.sleep(3000);
        nav.navBar.click();
        Thread.sleep(3000);
        whiteBoardPage = new WhiteBoardPage(driver);
        Thread.sleep(3000);
        whiteBoardPage.push.click();

    }
    public void finishPushWhiteBoard(IOSDriver driver,int width, int height) throws InterruptedException {
    }
}
