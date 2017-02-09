package appium;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ReadExcelPOI;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.round;

public class AixuepaiTestLine extends AppiumDriverBase {
    //Test Annotation changes any java function to TestNG test case
    //用画笔画直线
    @Test(dataProvider = "loginSucess")
    public void lineTest(String username, String pwd) throws Exception {

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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String selectClass = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals("选择班级", selectClass);

        driver.findElement(By.id("com.etiantian.pclass:id/ydt_part_over")).click();
        driver.findElement(By.id("com.etiantian.pclass:id/ydt_enter_over")).click();

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

        for(int i = 0;i<100;i++) {
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
            driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_clear")).click();
            driver.findElement(By.id("com.etiantian.pclass:id/negativeButton")).click();
            //开始录制
            driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_record")).click();
            double width1 = width * 0.7;
            double height1 = height * 0.8;
            int widthint = (int) round(width1);
            int heightint = (int) round(height1);

            for (int j = 0; j < 10;j++) {
                Random width2 = new Random();
                int widthlocal1 = width2.nextInt(widthint);
                Random height2 = new Random();
                int heightlocal2 = height2.nextInt(heightint);
                int widthlocal = width - widthlocal1;
                int heightlocal = height - heightlocal2;
                Random i1 = new Random();
                int i2 = i1.nextInt(widthlocal1);
                Random j1 = new Random();
                int j2 = i1.nextInt(heightlocal2);
                // System.out.println(widthlocal);
                //  System.out.println(heightlocal);
                //  System.out.println(i2);
                TouchAction clickClass3 = new TouchAction(driver);
                clickClass3.longPress(widthlocal, heightlocal).moveTo(widthlocal + i2, heightlocal + j2).release().perform();

                TouchAction clickClass4 = new TouchAction(driver);
                clickClass4.longPress(widthlocal - i2, heightlocal + j2).moveTo(widthlocal - j2, heightlocal).release().perform();

            }
            //停止录制
            driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_stop_record")).click();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            //预览页的引导图
            if (i ==0 ) {
                driver.findElement(By.id("com.etiantian.pclass:id/ydt_save_over")).click();
            }
            //开始播放
            driver.findElement(By.id("com.etiantian.pclass:id/start_bt")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //点击一下播放的页面
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(driver.findElement(By.id("com.etiantian.pclass:id/videoview"))).release().perform();
            //点击保存按钮
            driver.findElement(By.id("com.etiantian.pclass:id/lar_btn_save")).click();
            driver.findElement(By.id("com.etiantian.pclass:id/dialog_edit")).sendKeys("aaaaaa"+i);
            driver.findElement(By.id("com.etiantian.pclass:id/enterBtn")).click();
            driver.findElement(By.id("com.etiantian.pclass:id/lag_tag_more_img")).click();
            //过文件夹的引导图
            if(i==0) {
                driver.findElement(By.id("com.etiantian.pclass:id/ydt_folder_over")).click();
            }
            driver.findElement(By.id("com.etiantian.pclass:id/lftm_btn_folder")).click();
            driver.findElement(By.id("com.etiantian.pclass:id/ligf_card")).click();
            Assert.assertEquals("aaaaaa"+i, driver.findElement(By.id("com.etiantian.pclass:id/record_name")).getText());
            driver.findElement(By.id("com.etiantian.pclass:id/lfmf_btn_back")).click();
            driver.findElement(By.id("com.etiantian.pclass:id/lfmf_btn_back")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @DataProvider(name = "loginSucess")
    public Object[][] login() throws IOException {
        return ReadExcelPOI.getTestData("D:\\TestingForAiXuepaiData", "TestData.xls", "data");
    }
}