package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class PaperForCourseOneListPage {
    @FindBy(id = "课件")
    public WebElement classlist;
    @FindBy(id = "试卷")
    public WebElement paperlist;
    @FindBy(id = "总复习：现代诗、散文标准测试A")
    public WebElement paperOne;
    @FindBy(id = "总复习：现代诗、散文标准测试B")
    public WebElement paperTwo;
    @FindBy(id = "返回")
    public WebElement back;

    public PaperForCourseOneListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
