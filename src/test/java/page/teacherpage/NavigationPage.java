package page.teacherpage;

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
    @FindBy(id = "更多")
    public WebElement more;
    @FindBy(id = "退出")
    public WebElement exit;

    public NavigationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
