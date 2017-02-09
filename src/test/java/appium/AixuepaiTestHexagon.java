package appium;
import io.appium.java_client.MobileBy;
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

public class AixuepaiTestHexagon extends AppiumDriverBase {
    IsElementPresent elementPresent = new IsElementPresent();
    AlertPresent alertPresent = new AlertPresent();
    //画特殊图形多边形
    //Test Annotation changes any java function to TestNG test case
    @Test(dataProvider = "loginSucess")
    public void hexagonTest(String username, String pwd) throws Exception {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals("高二英语",driver.findElement(By.id("com.etiantian.pclass:id/lftc_txt_title")).getText());

        for(int i = 0;i<50;i++) {
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
            //选择多边形的特殊图形
            if(i==0) {
                driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_shape")).click();
                driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_shape")).click();
                driver.findElement(By.id("com.etiantian.pclass:id/btn_hexagon")).click();
            }
            //开始录制
            driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_record")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            double width1 = width * 0.8;
            double height1 = height * 0.8;
            int widthint = (int) round(width1);
            int heightint = (int) round(height1);
            Random r = new Random();
            int count = r.nextInt(5)+1;
            System.out.println("循环次数："+count);

            for (int j = 0; j < count;j++) {
                Thread.sleep(3000);
                Random r1 = new Random();
                int widthlocal = r1.nextInt(widthint-210)+210;
                int heightlocal = r1.nextInt(heightint-109)+109;

              //画多边形
                Random r2 = new Random();
                int counts = r2.nextInt(4 )+4;

                System.out.println("多边形的边数："+(counts-1));
                for (int k=0;k<counts;k++) {
                    Thread.sleep(1000);
                   // System.out.println("开始绘制多边形");
                    TouchAction clickClass3 = new TouchAction(driver);
                    int widthlocal1 = r1.nextInt(widthint-210)+210;
                    int heightlocal1 = r1.nextInt(heightint-109)+109;
                    if (k== 0) {
                        int widthdec = widthlocal;
                        int heightdes = heightlocal;
                       // System.out.println("点击第一个点");
                        clickClass3.press(widthdec, heightdes).release().perform();
                    }else if(k==counts-1){
                      //  System.out.println("最后一点");
                        clickClass3.press(widthlocal, heightlocal).release().perform();
                    }else{
                      //  System.out.println("其他点");
                        clickClass3.press(widthlocal1, heightlocal1).release().perform();
                    }
                }
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //判断是不是有提示信息出来
            /*
            if(elementPresent.isElementPresent(By.id("com.android.systemui:id/quick_settings_container"),driver)){
                System.out.println("提示信息出现");
                driver.findElement(By.id("com.android.systemui:id/notification_container_parent")).click();
            }
            */
            //停止录制
            driver.findElement(By.id("com.etiantian.pclass:id/wb_btn_stop_record")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //点击保存按钮
            driver.findElement(By.id("com.etiantian.pclass:id/lar_btn_save")).click();
            //输入保存的名称
            driver.findElement(By.id("com.etiantian.pclass:id/dialog_edit")).sendKeys("aaaaaa"+i);
            //点击确定按钮
            driver.findElement(By.id("com.etiantian.pclass:id/enterBtn")).click();
            //点击“更多”，进入更多页面
            driver.findElement(By.id("com.etiantian.pclass:id/lag_tag_more_img")).click();
            //过文件夹的引导图
            if(i==0) {
                driver.findElement(By.id("com.etiantian.pclass:id/ydt_folder_over")).click();
            }
            driver.findElement(By.id("com.etiantian.pclass:id/lftm_btn_folder")).click();
            driver.findElement(By.id("com.etiantian.pclass:id/ligf_card")).click();
            Assert.assertEquals("aaaaaa"+i, driver.findElement(By.id("com.etiantian.pclass:id/record_name")).getText());
            driver.findElement(By.id("com.etiantian.pclass:id/btn_upload")).click();
            driver.findElement(By.id("com.etiantian.pclass:id/positiveButton")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Assert.assertEquals("已上传",driver.findElement(By.id("com.etiantian.pclass:id/view_uploaded")).getText());
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