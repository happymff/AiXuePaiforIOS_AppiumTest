package AiXuepai;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by mengfeifei on 2016/12/29.
 */
public class RegisterTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/Users/mff/Desktop/workspace/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws Exception {
        driver.get("http://school.etiantian.com/dl910sxta/");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("爱学派C");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("a11111");
        driver.findElement(By.linkText("登　录")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("更多应用")).click();
        String winH1 = driver.getWindowHandle();
        driver.findElement(By.xpath("/html/body/div[11]/div/div/ul/li[1]/a/span")).click();
        Set<String> windows = driver.getWindowHandles();
        System.out.println(winH1);
        //System.out.println(driver.getWindowHandle());
        for (String str : windows) {
            System.out.println(str);
            if (!str.equals(winH1)) {
                driver.switchTo().window(str);
                System.out.println("切换到第二个window");
                break;
            } else {
                System.out.println("是第一个window~~~");
            }
        }
//        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).keyUp(Keys.CONTROL).sendKeys(Keys.NULL).perform();

        driver.findElement(By.id("添加")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("kaifa");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("a11111");
        driver.findElement(By.id("realname")).clear();
        driver.findElement(By.id("realname")).sendKeys("产品开发");
        driver.findElement(By.id("identity1")).click();
        driver.findElement(By.id("stuno")).clear();
        driver.findElement(By.id("stuno")).sendKeys("1111111111111111100");
        WebElement s1 = driver.findElement(By.id("sel_grade"));
        Select select1 = new Select(s1);
        select1.selectByValue("高一");
        WebElement s2 = driver.findElement(By.id("sel_cls"));
        Select select2 = new Select(s2);
        select2.selectByValue("开发产品班");
        driver.findElement(By.linkText("添 加")).click();

    }

    @AfterMethod
    public void tearDown() {//driver.quit();
    }
}
