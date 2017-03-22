package appium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.AlertPresent;
import util.IsElementPresent;

import java.util.Set;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class ChangeRealName {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/Users/mff/Desktop/workspace/chromedriver");
        driver = new ChromeDriver();
    }

    //@Test(description = "注册", dataProvider = "SeleniumTest", dataProviderClass = DataProvid.class)
    @Test
    //public void testRegister(String username, String pwd, String realname, String classNum) throws Exception {
    public void testChangeName() throws Exception {
        driver.get("http://school.etiantian.com/dl910sxta/");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("爱学派C");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("a11111");
        driver.findElement(By.linkText("登　录")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("更多应用")).click();
        String win1 = driver.getWindowHandle();
        driver.findElement(By.linkText("平台管理")).click();
        Thread.sleep(4000);
        Set<String> wins = driver.getWindowHandles();
        for (String win : wins) {
            if (!win.equalsIgnoreCase(win1)) {
                driver.switchTo().window(win);
                break;
            }
            Thread.sleep(3000);
        }
        Thread.sleep(2000);
        for (int i = 40; i < 100; i++) {
            int j =i;
            driver.findElement(By.linkText("查询")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("sel_username")).clear();
            driver.findElement(By.id("sel_username")).sendKeys("chanpinkaifa" + i);
            Thread.sleep(3000);
            driver.findElement(By.className("an_search")).click();
            Thread.sleep(3000);
            String s1 = "四中网校开发" + i;
            System.out.println(s1);
            IsElementPresent isElementPresent1 = new IsElementPresent();
            Boolean ispresent = isElementPresent1.isElementPresent(By.linkText(s1), driver);
            //System.out.println(ispresent);
            if (ispresent != true) {
                driver.findElement(By.linkText("2")).click();
                Thread.sleep(3000);
                driver.findElement(By.linkText(s1)).click();
            } else {
                driver.findElement(By.linkText(s1)).click();
            }
            Thread.sleep(3000);
            driver.findElement(By.id("edit_base")).click();
            Thread.sleep(3000);
            if (j < 20) {
                char c1 = (char) (j + 65);
                driver.findElement(By.id("txt_realname")).clear();
                driver.findElement(By.id("txt_realname")).sendKeys("夜华" + c1);
            } else if (20 <= j & j < 40) {
                j= j-20;
                char c1 = (char) (j + 65);
                driver.findElement(By.id("txt_realname")).clear();
                driver.findElement(By.id("txt_realname")).sendKeys("白浅" + c1);
            } else if (40 <= j & j < 60) {
                j= j-40;
                char c1 = (char) (j + 65);
                driver.findElement(By.id("txt_realname")).clear();
                driver.findElement(By.id("txt_realname")).sendKeys("东华" + c1);
            } else if (60 <= j & j < 80) {
                j= j-60;
                char c1 = (char) (j + 65);
                driver.findElement(By.id("txt_realname")).clear();
                driver.findElement(By.id("txt_realname")).sendKeys("凤九" + c1);
            } else if (80 <= j & j < 100) {
                j= j-80;
                char c1 = (char) (j + 65);
                driver.findElement(By.id("txt_realname")).clear();
                driver.findElement(By.id("txt_realname")).sendKeys("上神" + c1);
            }
            Thread.sleep(3000);
            driver.findElement(By.linkText("保存基本信息")).click();
            Thread.sleep(3000);
            Boolean isDisplay = driver.findElement(By.linkText("禁 用")).isDisplayed();
            if (isDisplay == true) {
                System.out.println("修改成功啦~~~~" + i + "~~~~~~~~~~~");
            }
            Assert.assertTrue(isDisplay);
            Thread.sleep(2000);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
