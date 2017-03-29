package page.teacherpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class ClassOnePage {
    @FindBy(id="课堂表现")
    public WebElement behaviour;
    @FindBy(id="cover")
    public WebElement student1;
    public ClassOnePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
