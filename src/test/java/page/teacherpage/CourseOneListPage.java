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
    public WebElement pdfClassAuto;
    @FindBy(id="appium测试")
    public WebElement pdfClassappium;
    @FindBy(id="诗两首")
    public WebElement wordClass;
    @FindBy(id="courselist_bg_ppt")
    public WebElement pptClass;
    @FindBy(id="返回")
    public WebElement back;
    @FindBy(id="第三方打开")
    public WebElement openWPS;
    @FindBy(id="推送打开")
    public WebElement openPush;
    @FindBy(id="取消")
    public WebElement cancel;

    public CourseOneListPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
