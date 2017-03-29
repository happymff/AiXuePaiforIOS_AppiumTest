package method;

import io.appium.java_client.ios.IOSDriver;
import page.commonpage.LoginPage;
import page.teacherpage.SelectClassPage;

/**
 * 滑动屏幕
 * Created by mff on 2017/3/28.
 */
public class SelectClass {
    SelectClassPage selectClassPage;

    //选取班级成功
    public void selectClass(IOSDriver driver) {
        selectClassPage = new SelectClassPage(driver);
        selectClassPage.classOne.click();
        selectClassPage.classTwo.click();
        selectClassPage.enterButton.click();
    }
    //退出选取班级页面
    public void exitSelectClass(IOSDriver driver) {
        selectClassPage = new SelectClassPage(driver);
        selectClassPage.exitButton.click();
    }
}
