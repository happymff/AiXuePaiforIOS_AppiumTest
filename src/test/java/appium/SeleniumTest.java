package appium;

import DataProvider.DataProvid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class SeleniumTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/Users/mengfeifei/Downloads/chromedriver");
        driver = new ChromeDriver();
    }

    @Test(description = "注册", dataProvider = "SeleniumTest", dataProviderClass = DataProvid.class)
    //@Test
    public void testRegister(String username, String pwd, String realname, String classNum) throws Exception {
        //public void testRegister() throws Exception {
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
            Thread.sleep(5000);
        }

        driver.findElement(By.linkText("添加")).click();
        driver.findElement(By.id("username")).clear();
        //driver.findElement(By.id("username")).sendKeys("sizhongwangxiaokaifa");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("pass")).clear();
        //driver.findElement(By.id("pass")).sendKeys("a11111");
        driver.findElement(By.id("pass")).sendKeys(pwd);
        driver.findElement(By.id("realname")).clear();
        //driver.findElement(By.id("realname")).sendKeys("四中网校开发");
        driver.findElement(By.id("realname")).sendKeys(realname);
        driver.findElement(By.xpath("//input[@value='学生']")).click();
        driver.findElement(By.id("stuno")).clear();
        //driver.findElement(By.id("stuno")).sendKeys("10000000000000001");
        driver.findElement(By.id("stuno")).sendKeys(classNum);
        WebElement grade = driver.findElement(By.id("sel_grade"));
        Select selectgrade = new Select(grade);
        selectgrade.selectByValue("高二");
        WebElement cls = driver.findElement(By.id("sel_cls"));
        Select selectcls = new Select(cls);
        selectcls.selectByValue("开发产品班");
        driver.findElement(By.linkText("添 加")).click();
        driver.findElement(By.linkText("创 建")).click();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
