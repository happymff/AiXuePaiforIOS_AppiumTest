package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class WhiteBoardPage {
    @FindBy(id="whiteboard tools forward defau")
    public WebElement forward;
    @FindBy(id="whiteboard tools backward defa")
    public WebElement backward;
    @FindBy(id="whiteboard tools backward defa")
    public WebElement set;
    @FindBy(id="whiteboard tools trash default")
    public WebElement trash;
    @FindBy(id="whiteboard tools save default")
    public WebElement save;
    @FindBy(id="whiteboard tools move default")
    public WebElement move;
    @FindBy(id="whiteboard tools image default")
    public WebElement img;
    @FindBy(id="whiteboard tools eraser defaul")
    public WebElement eraser;
    @FindBy(id="whiteboard tools text default")
    public WebElement text;
    @FindBy(id="whiteboard tools line default")
    public WebElement line;
    @FindBy(id="whiteboard tools triangle defa")
    public WebElement triangle;
    @FindBy(id="whiteboard tools quadrangle de")
    public WebElement quadrangle;
    @FindBy(id="whiteboard tools circle defaul")
    public WebElement circle;
    @FindBy(id="whiteboard page backward defau")
    public WebElement nextPage;
    @FindBy(id="推送")
    public WebElement push;
    @FindBy(id="whiteboard page forward defaul")
    public WebElement lastPage;

    public WhiteBoardPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
