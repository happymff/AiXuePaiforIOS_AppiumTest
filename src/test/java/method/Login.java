package method;

import io.appium.java_client.ios.IOSDriver;
import page.commonpage.LoginPage;

/**
 * 滑动屏幕
 * Created by mff on 2017/3/28.
 */
public class Login {
    LoginPage loginPage;

    //登录成功
    public void loginSucess(IOSDriver iosDriver, String username, String pwd) {
        loginPage = new LoginPage(iosDriver);
        loginPage.userName.clear();
        loginPage.userName.sendKeys(username);
        loginPage.headPic.click();
        loginPage.password.clear();
        loginPage.password.sendKeys(pwd);
        loginPage.headPic.click();
        loginPage.loginButton.click();
    }

    //登录成功
    public void loginFailed(IOSDriver iosDriver, String username, String pwd) {
        loginPage = new LoginPage(iosDriver);
        loginPage.userName.clear();
        loginPage.userName.sendKeys(username);
        loginPage.headPic.click();
        loginPage.password.clear();
        loginPage.password.sendKeys(pwd+"1");
        loginPage.headPic.click();
        loginPage.loginButton.click();
    }
}
