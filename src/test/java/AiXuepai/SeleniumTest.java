package AiXuepai;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by mengfeifei on 2016/12/29.
 */
public class SeleniumTest {
    WebDriver driver;
    @BeforeMethod
    public  void setUp() throws  Exception {

        System.setProperty("webdriver.chrome.driver", "/Users/mff/Desktop/workspace/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws Exception {
        driver.get("https://www.jiguang.cn/push");
        driver.findElement(By.linkText("立即使用")).click();
        Thread.sleep(5000);
        //driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"div-infoHintModal\"]/div/div[2]/div[2]/button[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).sendKeys("jjglobal@jjglobal.com");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/input")).sendKeys("jjglobal150505");
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div/div/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("推送")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"base-main\"]/div[2]/div/div/div[3]/div[2]/div[2]/div[1]/ul/li[8]/a/i")).click();
        Thread.sleep(2000);
       // driver.findElement(By.xpath("//*[@id=\"base-main\"]/div[2]/div/div/div/div[4]/div[2]/div[2]/div[1]/div[2]/ul/li[3]/i")).click();

       // driver.findElement(By.xpath("//*[@id=\"base-main\"]/div[2]/div/div/div/div[4]/div[2]/div[2]/div[1]/div[2]/ul/li[2]/i")).click();
       // driver.findElement(By.xpath("//*[@id=\"base-main\"]/div[2]/div/div/div/div[4]/div[4]/div[1]/span[2]")).click();
        //<i class="fa fa-apple apple-icon"></i>
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"base-main\"]/div[2]/div/div/div/div[4]/div[4]/div[1]/span[2]/i")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"extra-input\"]/ul/li/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"extra-input\"]/ul/li/input[1]")).clear();
        driver.findElement(By.xpath("//*[@id=\"extra-input\"]/ul/li/input[1]")).sendKeys("commodity");
        driver.findElement(By.xpath("//*[@id=\"extra-input\"]/ul/li/input[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"extra-input\"]/ul/li/input[2]")).clear();
        driver.findElement(By.xpath("//*[@id=\"extra-input\"]/ul/li/input[2]")).sendKeys("1773");
        for(int i = 0; i < 100;i ++){
            driver.findElement(By.xpath("//*[@id=\"base-main\"]/div[2]/div/div/div/div[4]/div[5]/div[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/button[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/button[2]")).click();
            Thread.sleep(20000);
        }
    }

    @AfterMethod
    public void tearDown(){//driver.quit();
    }
}
