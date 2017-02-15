package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class PushKejian {
    AndroidDriver driver ;

    public PushKejian(AndroidDriver driver){
        this.driver = driver;
    }
    public void enterKechengList() throws Exception{
        driver.findElement(By.id("com.etiantian.pclass:id/lag_tag_course")).click();
    }
    public void enterKejianList() throws Exception{
        List<WebElement> webElementList = driver.findElement(By.id("com.etiantian.pclass:id/lftc_rlv")).findElements(By.className("android.widget.RelativeLayout"));
        webElementList.get(0).click();
    }
    public void enterKejianDetail() throws Exception{
        List<WebElement> webElementList1 = driver.findElements(By.id("com.etiantian.pclass:id/ligcw_base"));
        webElementList1.get(0).click();
    }
    public void pushKejian() throws Exception{
                WebElement webElement =  driver.findElement(By.id("com.etiantian.pclass:id/ilpp_btn_push"));
        webElement.click();
    }
}
