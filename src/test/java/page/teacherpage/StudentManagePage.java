package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class StudentManagePage {
    @FindBy(id="navbar menu default")
    public WebElement navBar;
    @FindBy(id="manage_icon_lock_default")
    public WebElement lock;
    @FindBy(id="manage_icon_call_default")
    public WebElement call;
    @FindBy(id="manage_icon_answer_default")
    public WebElement quickAnswer;
    @FindBy(id="等待学生加入课堂")
    public WebElement nolineStudent;
    @FindBy(id="在线学生")
    public WebElement online;
    @FindBy(id="高二爱学派CS二班")
    public WebElement classOne;
    @FindBy(id="高二爱学派CS一班")
    public WebElement classTwo;
    @FindBy(id="旁听")
    public WebElement outClass;
    public StudentManagePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
