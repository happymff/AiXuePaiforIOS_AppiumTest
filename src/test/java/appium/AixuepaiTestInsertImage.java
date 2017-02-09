package appium;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.AlertPresent;
import util.IsElementPresent;
import util.ReadExcelPOI;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.round;

public class AixuepaiTestInsertImage extends AppiumDriverBase {
    IsElementPresent elementPresent = new IsElementPresent();
    AlertPresent alertPresent = new AlertPresent();
    //Test Annotation changes any java function to TestNG test case
    @Test(dataProvider = "loginSucess")
    public void loginTest(String username, String pwd) throws Exception {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        System.out.println(width);
        System.out.println(height);

        for (int i = 0; i < 4; i++) {
            // perform Drag and Drop
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            TouchAction dragNDrop = new TouchAction(driver);
            dragNDrop.longPress(width * 14 / 15, height / 2).moveTo(width / 15, height / 2).release().perform();
            }

        driver.findElement(By.id("com.etiantian.pclass:id/go_bt")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement ae1 = driver.findElement(By.id("com.etiantian.pclass:id/lag_ed_name"));
        //ae1.click();
        //ae1.clear();
        ae1.sendKeys(username);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement ae2 = driver.findElement(By.id("com.etiantian.pclass:id/lag_ed_pwd"));
        //ae2.click();
       // ae2.clear();
        ae2.sendKeys(pwd);
        driver.findElement(By.id("com.etiantian.pclass:id/lag_btn_login")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String selectClass = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals("选择班级", selectClass);

        driver.findElement(By.id("com.etiantian.pclass:id/ydt_part_over")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/ydt_enter_over")).click();
        //选择班级
        List<WebElement> ae3 = driver.findElement(By.id("com.etiantian.pclass:id/lacc_rlv")).findElements(By.className("android.widget.LinearLayout"));
       // System.out.print(ae3.size());
        TouchAction clickClass = new TouchAction(driver);
        clickClass.press(ae3.get(3).findElement(By.className("android.widget.RelativeLayout"))).release().perform();
        TouchAction clickClass1 = new TouchAction(driver);
        clickClass1.press(ae3.get(ae3.size()-2).findElement(By.className("android.widget.RelativeLayout"))).release().perform();
        TouchAction clickClass2 = new TouchAction(driver);
        clickClass2.press(ae3.get(ae3.size()-1).findElement(By.className("android.widget.RelativeLayout"))).release().perform();

        driver.findElement(By.id("com.etiantian.pclass:id/lacc_btn_ready")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals("高二英语",driver.findElement(By.id("com.etiantian.pclass:id/lftc_txt_title")).getText());

        for(int i = 0;i<10;i++) {
            System.out.println();
            System.out.println("循环第"+(i+1)+"次");
            System.out.println();
            driver.findElement(By.id("com.etiantian.pclass:id/lag_tag_wboard_img")).click();
            //过白板页面的引导图
            if(i==0) {
                driver.findElement(By.id("com.etiantian.pclass:id/ydt_shape_over")).click();
                driver.findElement(By.id("com.etiantian.pclass:id/ydt_txt_over")).click();
                driver.findElement(By.id("com.etiantian.pclass:id/ydt_record_over")).click();
                driver.findElement(By.id("com.etiantian.pclass:id/ydt_stop_over")).click();
                driver.findElement(By.id("com.etiantian.pclass:id/ydt_fbtn_over")).click();
            }
            //点击白板的清空按钮
            if(i!=0) {
                driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_clear")).click();
                driver.findElement(By.id("com.etiantian.pclass:id/negativeButton")).click();
            }
            for (int j =0;j<3;j++) {
                driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_img")).click();
                driver.findElement(By.id("com.etiantian.pclass:id/pop_btn_album")).click();
                Thread.sleep(3000);
                TouchAction clickClass11 = new TouchAction(driver);
                clickClass11.press(737,617).release().perform();
                Thread.sleep(1000);
                TouchAction clickClass12 = new TouchAction(driver);
                clickClass12.press(961,613).release().perform();
                Thread.sleep(1000);
                driver.findElement(By.id("com.android.gallery3d:id/filtershow_done")).click();
                Thread.sleep(6000);
                System.out.println("加载第"+(j+1)+"张");
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @DataProvider(name = "loginSucess")
    public Object[][] login() throws IOException {
        return ReadExcelPOI.getTestData("D:\\TestingForAiXuepaiData", "TestData.xls", "data");
    }
}