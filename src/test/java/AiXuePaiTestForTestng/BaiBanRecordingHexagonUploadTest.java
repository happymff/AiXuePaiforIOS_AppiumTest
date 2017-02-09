package AiXuePaiTestForTestng;

import DataProvider.DataProvid;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.*;
import util.Initialize;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class BaiBanRecordingHexagonUploadTest {
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
    DrawHexagon drawHexagon;
    SelectSpecialFigure selectSpecialFigure;
    Upload upload;
    @BeforeMethod
    public  void setUp() throws  Exception {
       initialize = new Initialize();
        // initializing driver object
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize());
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Parameters({"username","pwd"})
    @Test
    public void recordHexagonUploadTest1(String username, String pwd) throws Exception {
        loginPage = new LoginPage(username,pwd,driver);
        Thread.sleep(2000);
        loginPage.loginSuccess();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(3000);
        switchLoginPageYindaoImage = new SwitchLoginPageYindaoImage(driver);
        switchLoginPageYindaoImage.switchYindaoImage();
        selectClass =new SelectClass(driver);
        selectClass.selectClass();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baiban=new GoIntoBaiban(driver);
        baiban.goIntoBaiBan();
        switchBaiBanYindaoImage = new SwitchBaiBanYindaoImage(driver);
        switchBaiBanYindaoImage.switchBaibanYindaoImage();
        recordAndPause = new RecordAndPause(driver);
        recordAndPause.record();
        Thread.sleep(3000);
        selectSpecialFigure = new SelectSpecialFigure(driver);
        selectSpecialFigure.selectSpecialFigure("hexagon");
        drawHexagon = new DrawHexagon(driver);
        for(int i = 0 ;i <10; i++) {
            drawHexagon.drawHexagon();
            Thread.sleep(1000);
        }
        recordAndPause.pause();
        switchRecordCompleteYindaoImage = new SwitchRecordCompleteYindaoImage(driver);
        switchRecordCompleteYindaoImage.switchRecordCompleteYindaoImage();
        previewAndSaveRecording = new PreviewAndSaveRecording(driver);
        previewAndSaveRecording.previewRecording();
        previewAndSaveRecording.saveRecording("TestRecord");
        morePage = new MorePage(driver);
        morePage.morePage();
        morePage.morePageYinDaoImage();
        fileFolder = new FileFolder(driver);
        fileFolder.goIntoFileFolder();
        upload = new Upload(driver);
        upload.upload();
        Thread.sleep(3000);
        Assert.assertEquals("已上传",driver.findElement(By.id("com.etiantian.pclass:id/view_uploaded")).getText());
        fileFolder.returnFileFolder();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
