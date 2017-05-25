
package lixiuzhi;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.FileUtils;


public class my_profile_delete_contacts {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver driver = null;

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6.0");
        caps.setCapability("deviceName", "3DN0216524001409");
        caps.setCapability("browserName", "");
        //relative path to apk file
        final File classpathRoot = new File(System.getProperty("user.dir"));
        final File appDir = new File(classpathRoot, "src/test/resource/");
        final File app = new File(appDir, "app-dev-debug0217aixue.apk");

//	  设置每次运行不重新启动被测试app
//        caps.setCapability("noReset","true");
//        caps.setCapability("fullReset","false");

        //出错时截屏并输出log


        caps.setCapability("app", app.getAbsolutePath());
        //initializing driver object

        //support Chinese
        caps.setCapability("unicodeKeyboard", "True");
        caps.setCapability("resetKeyboard", "True");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait((WebDriver) driver, 10);

        //截屏
        //File scrFile = (File) driver.getScreenshotAs(OutputType.FILE);

        try{
            Thread.sleep(3000);

            int width = driver.manage().window().getSize().width;
            int height = driver.manage().window().getSize().height;

            for (int i = 0; i < 2; i++) {
                Thread.sleep(5000);
                //用longpress方法
                //TouchAction dragNDrop = new TouchAction(driver);
                //dragNDrop.longPress(width * 6 / 7, height / 2).moveTo(width / 7, height / 2).release().perform();
                //用swipe方法
                driver.swipe(width*6/7, height/2, width/7, height/2, 1000);
            }
            driver.findElement(By.id("立即体验")).click();
          //  driver.findElementBy("立即体验")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("com.etiantian.im:id/positiveButton")).click();
            driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();

            driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();

            WebElement username = driver.findElement(By.id("com.etiantian.im:id/et_username"));
            WebElement password = driver.findElement(By.id("com.etiantian.im:id/et_password"));

            Thread.sleep(1000);
            username.sendKeys(new String[] { "dlgs3@ett.com" });
            Thread.sleep(1000);
            password.sendKeys(new String[] { "a11111" });
            //点击登录按钮
            driver.findElement(By.id("com.etiantian.im:id/login_btn")).click();
            Thread.sleep(2000);
            //点击“我的”
            driver.findElementByAccessibilityId("我的").click();
           // driver.findElement(By.name("我的")).click();
            Thread.sleep(3000);
            //点击好友
//	    driver.findElement(By.name("好友")).click();
//	    Thread.sleep(2000);
            driver.tap(1, 673, 711, 10);
            Thread.sleep(2000);
            //System.out.print(driver.findElement(By.name("我的关注")));
            driver.findElementByAccessibilityId("我的关注").click();
            //driver.findElement(By.name("我的关注")).click();
            Thread.sleep(2000);
//
//	    boolean b1 = driver.findElement(By.name("刘")).isDisplayed();
//	    System.out.print(b1);
            boolean b1= false;
           List<WebElement> l1= driver.findElements(By.id("com.etiantian.im:id/txt_name"));
           for (int i =0; i < l1.size(); i++){
              if (l1.get(i).getText().equals("刘")){
                  b1 = true;
                  break;
               }else{
                  b1 = false;
              }
           }
            //boolean b1 = driver.findElementByAccessibilityId("刘").isDisplayed();

            //boolean b1 =isElementPresent(By.name("刘"),driver);
            System.out.print(b1);
            //if(driver.findElement(By.name("刘")).isDisplayed())
            if(b1)
            {
                driver.findElementByAccessibilityId("刘").click();
                //driver.findElement(By.name("刘")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("com.etiantian.im:id/title_img")).click();
                Thread.sleep(2000);
                driver.findElementByAccessibilityId("取消关注").click();
                //driver.findElement(By.name("取消关注")).click();
                Thread.sleep(2000);

                System.out.print("取消关注联系人成功, pass!");
            }
            else
            {
                System.out.print("-----enter in else------------------");
                //点击添加联系人
                Thread.sleep(2000);
                driver.findElement(By.id("com.etiantian.im:id/title_img")).click();
                Thread.sleep(2000);
                WebElement search=driver.findElement(By.id("com.etiantian.im:id/found_search_frame"));
                Thread.sleep(1000);
                search.sendKeys(new String[]{"刘"});
                Thread.sleep(1000);
                //点击搜索
                driver.findElement(By.id("com.etiantian.im:id/found_search_btn")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("com.etiantian.im:id/txt_name")).click();
                Thread.sleep(2000);
                driver.findElementByAccessibilityId("关 注").click();
               // driver.findElement(By.name("关 注")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("com.etiantian.im:id/title_back")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("com.etiantian.im:id/title_back_img")).click();
                Thread.sleep(2000);
                //去我的关注中看是否含有已添加联系人
                driver.findElementByAccessibilityId("我的关注").click();
                //driver.findElement(By.name("我的关注")).click();
                Thread.sleep(2000);
                driver.findElementByAccessibilityId("刘").click();
                //driver.findElement(By.name("刘")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("com.etiantian.im:id/title_img")).click();
                Thread.sleep(2000);
                driver.findElementByAccessibilityId("取消关注").click();
                //driver.findElement(By.name("取消关注")).click();
                Thread.sleep(2000);
                System.out.print("取消关注联系人成功, pass!");
            }


        }catch (Exception e){
            System.out.print("出错了！");
            System.out.print(e.toString());
        }finally{
            driver.quit();
        }
    }


    public static boolean isElementPresent(By by, WebDriver driver) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

