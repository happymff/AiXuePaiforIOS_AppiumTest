package page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class DrawHexagon {
    AndroidDriver driver ;

    public DrawHexagon(AndroidDriver driver){
        this.driver = driver;
    }
    public void drawHexagon() throws Exception{
        int width = driver.manage().window().getSize().width;
        int heigth = driver.manage().window().getSize().height;
        Random r1 = new Random();
        int widthlocal = r1.nextInt(width - 220) + 210;
        int heightlocal = r1.nextInt(heigth - 120) + 109;
        Random r2 = new Random();
        int counts = r2.nextInt(7) + 4;
       // System.out.println("多边形的边数：" + (counts - 1));
        for (int k = 0; k < counts; k++) {
            Thread.sleep(1000);
            // System.out.println("开始绘制多边形");
            TouchAction clickClass3 = new TouchAction(driver);
            int widthlocal1 = r1.nextInt(width - 215) + 210;
            int heightlocal1 = r1.nextInt(heightlocal - 110) + 109;
            if (k == 0) {
                // System.out.println("点击第一个点");
                clickClass3.press(widthlocal, heightlocal).release().perform();
            } else if (k == counts - 1) {
                //  System.out.println("最后一点");
                clickClass3.press(widthlocal, heightlocal).release().perform();
            } else {
                //  System.out.println("其他点");
                clickClass3.press(widthlocal1, heightlocal1).release().perform();
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
}
