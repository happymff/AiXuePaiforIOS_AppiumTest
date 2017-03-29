package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class CoursePaperDetailPage {
    @FindBy(id="推题")
    public WebElement pushQuestion;
    @FindBy(id="推试卷")
    public WebElement pushPaper;
    @FindBy(id="返回")
    public WebElement back;

    public CoursePaperDetailPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
