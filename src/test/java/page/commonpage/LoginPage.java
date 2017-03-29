package page.commonpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mff on 2017/3/28.
 */
public class LoginPage {
    @FindBy(className="UIATextField")
    public WebElement userName;
    @FindBy(className="UIASecureTextField")
    public WebElement password;
    @FindBy(id="登录")
    public WebElement loginButton;
    @FindBy(id="记住用户信息")
    public WebElement recordUser;
    @FindBy(id="login_default_icon")
    public WebElement headPic;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
