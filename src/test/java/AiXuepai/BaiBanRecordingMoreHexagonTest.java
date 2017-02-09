package AiXuepai;

import DataProvider.DataProvid;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;
import util.Initialize;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class BaiBanRecordingMoreHexagonTest {
    AndroidDriver driver;
    Initialize initialize;
    LoginPage loginPage;
    SwitchLoginPageYindaoImage switchLoginPageYindaoImage;
    SelectClass selectClass;
    GoIntoBaiban baiban;
    RecordAndPause recordAndPause;
    SwitchBaiBanYindaoImage switchBaiBanYindaoImage;
    SwitchRecordCompleteYindaoImage switchRecordCompleteYindaoImage;
    PreviewAndSaveRecording previewAndSaveRecording;
    FileFolder fileFolder;
    MorePage morePage;
    //DrawFigure  drawFigure;
    DrawHexagon drawHexagon;
    SelectSpecialFigure selectSpecialFigure;
    ClearBaiban clearBaiban;
    @BeforeMethod
    public  void setUp() throws  Exception {
       initialize = new Initialize();
        // initializing driver object
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize());
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }


    @Test(description = "登陆成功",dataProvider = "LoginSucess",dataProviderClass = DataProvid.class)
    public void recordMoreCicleTest(String username, String pwd) throws Exception {
        loginPage = new LoginPage(username,pwd,driver);
        Thread.sleep(2000);
        loginPage.loginSuccess();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(3000);
        switchLoginPageYindaoImage = new SwitchLoginPageYindaoImage(driver);
        Thread.sleep(2000);
        switchLoginPageYindaoImage.switchYindaoImage();
        selectClass =new SelectClass(driver);
        selectClass.selectClass();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        for (int j = 0; j<10; j++) {
            baiban = new GoIntoBaiban(driver);
        baiban.goIntoBaiBan();
            if(j!=0){
                clearBaiban = new ClearBaiban(driver);
                clearBaiban.clearBaiBan();
            }
            if(j==0) {
                switchBaiBanYindaoImage = new SwitchBaiBanYindaoImage(driver);
                switchBaiBanYindaoImage.switchBaibanYindaoImage();
            }
        recordAndPause = new RecordAndPause(driver);
        recordAndPause.record();
        Thread.sleep(3000);
            if (j==0) {
                selectSpecialFigure = new SelectSpecialFigure(driver);
                selectSpecialFigure.selectSpecialFigure("hexagon");
            }
            drawHexagon = new DrawHexagon(driver);
            for(int k = 0 ;k<10; k++) {
                drawHexagon.drawHexagon();
                Thread.sleep(1000);
            }

            recordAndPause.pause();
            if (j==0) {
                switchRecordCompleteYindaoImage = new SwitchRecordCompleteYindaoImage(driver);
                switchRecordCompleteYindaoImage.switchRecordCompleteYindaoImage();
            }
            previewAndSaveRecording = new PreviewAndSaveRecording(driver);
            previewAndSaveRecording.previewRecording();
            previewAndSaveRecording.saveRecording("TestRecord"+j);
            morePage = new MorePage(driver);
            morePage.morePage();
            if(j==0) {
                morePage.morePageYinDaoImage();
            }
            fileFolder = new FileFolder(driver);
            fileFolder.goIntoFileFolder();
            Assert.assertEquals("TestRecord"+j, driver.findElement(By.id("com.etiantian.pclass:id/record_name")).getText());
            fileFolder.returnFileFolder();
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
