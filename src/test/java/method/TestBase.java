package method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by mff on 2017/5/12.
 */
public class TestBase {
    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp(){
        //options.setExperimentalOption("forceDevToolsScreenshot", true);
        System.setProperty("webdriver.chrome.driver", "/Users/mff/Desktop/workspace/chromedriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.baidu.com");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
