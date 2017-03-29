package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class MyCoursePage {
    @FindBy(id="总复习：现代诗、散文")
    public WebElement courseOne;
    @FindBy(id="总复习：图文转换")
    public WebElement courseTwo;
    @FindBy(id="navbar menu default")
    public WebElement nav;
    @FindBy(id="高二语文")
    public WebElement title;
    @FindBy(id="(11)")
    public WebElement courseOneNum;
    @FindBy(id="(2)")
    public WebElement courseOnePaper;

    public MyCoursePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
