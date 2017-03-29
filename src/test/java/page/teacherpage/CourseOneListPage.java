package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class CourseOneListPage {
    @FindBy(id="课件")
    public WebElement classlist;
    @FindBy(id="试卷")
    public WebElement paperlist;
    @FindBy(id="自动化测试需要")
    public WebElement pdfClass;
    @FindBy(id="诗两首")
    public WebElement wordClass;
    @FindBy(id="courselist_bg_ppt")
    public WebElement pptClass;
    @FindBy(id="返回")
    public WebElement back;

    public CourseOneListPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
