package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class BaibanAdd_Manage {
    AndroidDriver driver ;

    public BaibanAdd_Manage(AndroidDriver driver){
        this.driver = driver;
    }
    public void addBaiBan(){
        //点击快捷按钮
        driver.findElement(By.id("com.etiantian.pclass:id/wb_menu")).click();
        //点击新建白板
        driver.findElement(By.id("com.etiantian.pclass:id/wb_menu_add")).click();
    }
    public void manageBaiBan(){
        //点击快捷按钮
        driver.findElement(By.id("com.etiantian.pclass:id/wb_menu")).click();
        //点击白板管理
        driver.findElement(By.id("com.etiantian.pclass:id/wb_menu_manager")).click();
        //点击编辑
        driver.findElement(By.id("com.etiantian.pclass:id/lfbl_btn_edit")).click();
        //点击全选
        driver.findElement(By.id("com.etiantian.pclass:id/lfbl_btn_all")).click();
        //点击删除
        driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_clear")).click();
        //点击取消
        driver.findElement(By.id("com.etiantian.pclass:id/lfbl_btn_edit")).click();
        //点击返回
        driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_clear")).click();
    }
}
