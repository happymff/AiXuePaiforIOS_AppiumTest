package method;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import page.teacherpage.*;
import util.IsElementPresent;

/**
 * 滑动屏幕
 * Created by mff on 2017/3/28.
 */
public class PushPaper {
    NavigationPage nav;
    MyCoursePage myCoursePage;
    PaperForCourseOneListPage paper;
    CoursePaperDetailPage paperDetailPage;

    //推送试卷
    public void pushPaperOne(IOSDriver driver) throws InterruptedException {
        nav = new NavigationPage(driver);
        System.out.println(driver.findElementsByAccessibilityId("我的课程").size());
        nav.navBar.click();
        Thread.sleep(3000);
        nav.myCourse.click();
        Thread.sleep(3000);
        nav.navBar.click();
        Thread.sleep(3000);
        myCoursePage = new MyCoursePage(driver);
        Thread.sleep(3000);
        myCoursePage.courseOnePaper.click();
        paper = new PaperForCourseOneListPage(driver);
        paper.paperOne.click();
        Thread.sleep(3000);
        try {
            paperDetailPage = new CoursePaperDetailPage(driver);
            paperDetailPage.pushPaper.click();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void finishPushPaperOne(IOSDriver driver) throws InterruptedException {

    }
}
