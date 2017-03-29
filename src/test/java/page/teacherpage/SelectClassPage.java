package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class SelectClassPage {
    @FindBy(id="高二爱学派CS二班")
    public WebElement classOne;
    @FindBy(id="高二爱学派CS一班")
    public WebElement classTwo;
    @FindBy(id="进入课堂")
    public WebElement enterButton;
    @FindBy(id="退出")
    public WebElement exitButton;
    public SelectClassPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
