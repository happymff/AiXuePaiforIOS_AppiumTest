package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class MorePage {
    AndroidDriver driver ;

    public MorePage(AndroidDriver driver){
        this.driver = driver;
    }
    public void morePage(){
        //点击“更多”，进入更多页面
        driver.findElement(By.id("com.etiantian.pclass:id/lag_tag_more_img")).click();
    }
    public void morePageYinDaoImage(){
        //过文件夹的引导图
        driver.findElement(By.id("com.etiantian.pclass:id/ydt_folder_over")).click();
    }
}
