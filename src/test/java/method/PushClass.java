package method;

import io.appium.java_client.ios.IOSDriver;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.openqa.selenium.By;
import page.teacherpage.*;
import util.IsElementPresent;

/**
 * 滑动屏幕
 * Created by mff on 2017/3/28.
 */
public class PushClass {
    NavigationPage nav;
    MyCoursePage myCoursePage;
    CourseOneListPage courseOneListPage;
    CourseClassDetailPage courseClassDetailPage;

    //推送课件
    public void pushClassOne(IOSDriver driver) throws InterruptedException {
        nav = new NavigationPage(driver);
        System.out.println(driver.findElementsByAccessibilityId("我的课程").size());
        //nav.myCourse.click();
        //System.out.println(nav.myCourse);
        nav.navBar.click();
        Thread.sleep(3000);
        nav.myCourse.click();
        Thread.sleep(3000);
        nav.navBar.click();
        Thread.sleep(3000);
        myCoursePage = new MyCoursePage(driver);
        Thread.sleep(3000);
        myCoursePage.courseOne.click();
        courseOneListPage = new CourseOneListPage(driver);
        courseOneListPage.pdfClassAuto.click();
        Thread.sleep(3000);
        while (true) {
            IsElementPresent isElementPresent = new IsElementPresent();
            Boolean b1 = isElementPresent.isElementPresent(By.id("取消"), driver);
            if (b1) {
                Thread.sleep(5000);
            }
            else {
                courseOneListPage.pdfClassAuto.click();
                break;
            }
        }
        courseOneListPage.openPush.click();
        Thread.sleep(5000);
        courseClassDetailPage = new CourseClassDetailPage(driver);
        Thread.sleep(1000);
        courseClassDetailPage.push.click();
    }
    public void finishPushClassOne(IOSDriver driver,int width, int height) throws InterruptedException {
        ClassDetailPushPage classDetailPushPage = new ClassDetailPushPage(driver);
        driver.tap(1, width / 2, height / 2, 500); //fingers 手指数量
        System.out.println("点击屏幕成功");
        classDetailPushPage.finishPush.click();
    }
}
