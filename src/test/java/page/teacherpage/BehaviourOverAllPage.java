package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class BehaviourOverAllPage {
    @FindBy(id="本节")
    public WebElement thisClass;
    @FindBy(id="累计")
    public WebElement overAll;
    @FindBy(id="奖励得分")
    public WebElement reward;
    @FindBy(id="抢答")
    public WebElement quickAnswer;
    @FindBy(id="被点名")
    public WebElement callCount;
    @FindBy(id="提醒")
    public WebElement remind;
    @FindBy(id="返回")
    public WebElement back;

    public BehaviourOverAllPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
