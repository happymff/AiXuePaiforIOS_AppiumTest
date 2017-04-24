package method;

import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import page.teacherpage.*;

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
        nav = new NavigationPage();
        System.out.println(driver.findElementsByAccessibilityId("我的课程").size());
        nav.nav(driver);
        //System.out.println(nav.myCourse);
        nav.navBar.click();
        Thread.sleep(3000);
        nav.myCourse.click();
        Thread.sleep(3000);
        nav.navBar.click();
        myCoursePage = new MyCoursePage(driver);
        myCoursePage.courseOne.click();
        courseOneListPage = new CourseOneListPage(driver);
        courseOneListPage.pdfClass.click();
        courseClassDetailPage = new CourseClassDetailPage(driver);
        courseClassDetailPage.push.click();
    }
    //推送课件
    public void finishPushClassTwo(IOSDriver driver) {
        nav = new NavigationPage();
        nav.navBar.click();
//        myCoursePage = new MyCoursePage(driver);
//        myCoursePage.courseTwo.click();
//        courseOneListPage = new CourseOneListPage(driver);
//        courseOneListPage.pdfClass.click();
//        courseClassDetailPage = new CourseClassDetailPage(driver);
//        courseClassDetailPage.push.click();

    }
}
