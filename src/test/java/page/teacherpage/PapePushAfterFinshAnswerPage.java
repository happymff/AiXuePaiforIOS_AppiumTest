package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class PapePushAfterFinshAnswerPage {
    @FindBy(id = "试卷统计")
    public WebElement sum;
    @FindBy(id = "结束推送")
    public WebElement finishPush;
    @FindBy(id = "已公布答案")
    public WebElement afterAnswer;

    public PapePushAfterFinshAnswerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
