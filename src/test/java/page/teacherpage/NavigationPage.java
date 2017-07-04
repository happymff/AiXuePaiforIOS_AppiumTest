package page.teacherpage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class NavigationPage {
    @FindBy(id = "学生管理")
    public WebElement studentManage;
    @FindBy(id = "我的课程")
    public WebElement myCourse;
    @FindBy(id = "电子白板")
    public WebElement whiteBoard;
    //public WebElement whiteBoard;
    @FindBy(id = "更多")
    public WebElement more;
    @FindBy(id = "退出")
    public WebElement exit;
    @FindBy(id = "navbar menu default")
    public WebElement navBar;
    public NavigationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
// public WebElement navBar,studentManage,myCourse,whiteBoard,more,exit;
//    public void nav(IOSDriver driver){
//        studentManage = driver.findElementByAccessibilityId("学生管理");
//        myCourse = (WebElement) driver.findElementsByAccessibilityId("我的课程").get(1);
//        whiteBoard = driver.findElementByAccessibilityId("电子白板");
//        more = driver.findElementByAccessibilityId("更多");
//        exit = driver.findElementByAccessibilityId("退出");
//        navBar = driver.findElementByAccessibilityId("navbar menu default");
//    }

}
