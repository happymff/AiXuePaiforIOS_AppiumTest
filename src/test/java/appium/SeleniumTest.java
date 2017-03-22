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
public class SeleniumTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/Users/mff/Desktop/workspace/chromedriver");
        driver = new ChromeDriver();
    }

    //@Test(description = "注册", dataProvider = "SeleniumTest", dataProviderClass = DataProvid.class)
    @Test
    //public void testRegister(String username, String pwd, String realname, String classNum) throws Exception {
    public void testRegister() throws Exception {
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
        for (int i = 70; i < 100; i++) {
            driver.findElement(By.linkText("添加")).click();
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys("chanpinkaifa" + i);
            //driver.findElement(By.id("username")).sendKeys(username);
            Thread.sleep(3000);
            driver.findElement(By.id("pass")).clear();
            Thread.sleep(3000);
            driver.findElement(By.id("pass")).sendKeys("a11");
            Thread.sleep(2000);
            driver.findElement(By.id("pass")).sendKeys("111");
            driver.findElement(By.id("realname")).click();
            Thread.sleep(3000);
            System.out.println(driver.findElement(By.id("pass")).getText());
            IsElementPresent isElementPresent = new IsElementPresent();
            do {
                Boolean b1 = isElementPresent.isElementPresent(By.id("pwd_err"), driver);
                String s1 = driver.findElement(By.id("pwd_err")).getText();
                System.out.println(s1);
                if ("长度小于6字符".equalsIgnoreCase(s1)) {
                    driver.findElement(By.id("pass")).clear();
                    Thread.sleep(5000);
                    driver.findElement(By.id("pass")).sendKeys("a11");
                    Thread.sleep(2000);
                    driver.findElement(By.id("pass")).sendKeys("111");
                    Thread.sleep(5000);
                    driver.findElement(By.id("pass")).click();
                    System.out.println(driver.findElement(By.id("pass")).getText());
                    Thread.sleep(2000);
                }else {
                    break;
                }
            }while (true);
            //driver.findElement(By.id("pass")).sendKeys(pwd);
            Thread.sleep(3000);
            driver.findElement(By.id("realname")).clear();
            driver.findElement(By.id("realname")).sendKeys("四中网校开发" + i);
            //driver.findElement(By.id("realname")).sendKeys(realname);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@value='学生']")).click();
            driver.findElement(By.id("stuno")).clear();
            driver.findElement(By.id("stuno")).sendKeys("12345678900000000" + i);
            Thread.sleep(2000);
            IsElementPresent isElementPresent1 = new IsElementPresent();
            int num = 0;
            do {
                Boolean b2 = isElementPresent1.isElementPresent(By.id("stuno_err"), driver);
                String s2 = driver.findElement(By.id("stuno_err")).getText();
                System.out.println(s2);
                if ("学号已存在".equalsIgnoreCase(s2)) {
                    driver.findElement(By.id("stuno")).sendKeys("99");
                }else {
                    break;
                }
                num = num + 1;
                System.out.println(num);
                if(num >= 5){
                    driver.findElement(By.id("stuno")).sendKeys("158751148944152154" + i);
                }
            }while(true);
            Thread.sleep(3000);
            //driver.findElement(By.id("stuno")).sendKeys(classNum);
            //driver.findElement(By.id("stuno")).sendKeys("1");
            // Thread.sleep(5000);
            WebElement grade = driver.findElement(By.id("sel_grade"));
            Thread.sleep(2000);
            Select selectgrade = new Select(grade);
            selectgrade.selectByValue("高一");
            Thread.sleep(2000);
            WebElement cls = driver.findElement(By.id("sel_cls"));
            Thread.sleep(2000);
            Select selectcls = new Select(cls);
            selectcls.selectByValue("1274997");
            Thread.sleep(2000);
            driver.findElement(By.linkText("添 加")).click();
            driver.findElement(By.linkText("创 建")).click();
            AlertPresent alertPresent = new AlertPresent();
            Boolean accept = alertPresent.isAlertPresent(driver);
            alertPresent.acceptAlert(driver, accept);
            Thread.sleep(3000);
            AlertPresent alertPresent1 = new AlertPresent();
            Boolean accept1 = alertPresent1.isAlertPresent(driver);
            alertPresent.acceptAlert(driver, accept1);
            Thread.sleep(5000);
            IsElementPresent isElementPresent3 = new IsElementPresent();
            Boolean isEl = isElementPresent3.isElementPresent(By.linkText("禁 用"), driver);
            Boolean isDisplay = driver.findElement(By.linkText("禁 用")).isDisplayed();
            if (isDisplay == true) {
                System.out.println("注册成功啦~~~~" + i + "~~~~~~~~~~~");
            }
            Assert.assertTrue(isEl);
            Thread.sleep(2000);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
