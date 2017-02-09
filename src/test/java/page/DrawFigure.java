package page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.Random;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class DrawFigure {
    AndroidDriver driver ;

    public DrawFigure(AndroidDriver driver){
        this.driver = driver;
    }
    public void drawFigure(){
        int width = driver.manage().window().getSize().width;
        int heigth = driver.manage().window().getSize().height;
        Random r1 = new Random();
        int widthlocal = r1.nextInt(width-210)+210;
        int heightlocal = r1.nextInt(heigth-109)+109;

        int widthdec = r1.nextInt(width-210)+210;
        int heightdes = r1.nextInt(heigth-109)+109;

        TouchAction clickClass3 = new TouchAction(driver);
        clickClass3.longPress(widthlocal, heightlocal).moveTo(widthdec, heightdes).release().perform();
    }

}
