package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class CourseClassDetailPage {
    @FindBy(id="推送")
    public WebElement push;
    @FindBy(id="返回")
    public WebElement back;

    public CourseClassDetailPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
