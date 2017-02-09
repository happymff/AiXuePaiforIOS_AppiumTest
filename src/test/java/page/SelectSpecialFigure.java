package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class SelectSpecialFigure {
    AndroidDriver driver ;

    public SelectSpecialFigure(AndroidDriver driver){
        this.driver = driver;
    }
    public void selectSpecialFigure(String figure){
        driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_shape")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_shape")).click();
        if (figure=="line") {
            driver.findElement(By.id("com.etiantian.pclass:id/btn_line")).click();
        }else if(figure=="triangle"){
            driver.findElement(By.id("com.etiantian.pclass:id/btn_triangle")).click();
        }else if(figure=="ellipse"){
            driver.findElement(By.id("com.etiantian.pclass:id/btn_ellipse")).click();
        }else if(figure=="circle"){
            driver.findElement(By.id("com.etiantian.pclass:id/btn_circle")).click();
        }else if(figure=="hexagon"){
            driver.findElement(By.id("com.etiantian.pclass:id/btn_hexagon")).click();
        }else if(figure=="rectangle"){
            driver.findElement(By.id("com.etiantian.pclass:id/btn_rectangle")).click();
        }else {
            System.out.println("No Such figure in BaiBan,Please NOTE!!!");
        }
    }

}
