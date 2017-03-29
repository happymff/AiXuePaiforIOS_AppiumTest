package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class QuestionPushPage {
    @FindBy(id = "结束作答")
    public WebElement finishAnswer;
    @FindBy(id = "返回")
    public WebElement back;

    public QuestionPushPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
