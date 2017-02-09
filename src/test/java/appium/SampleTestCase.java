package appium;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.
        ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class SampleTestCase extends AppiumDriverBase{
    //Test Annotation changes any java function to TestNG test case
    @Test
    public void sampeTest() throws Exception{
//click on Accessibility link
        //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility")));


       // wait.until(ExpectedConditions. presenceOfElementLocated (MobileBy. AccessibilityId ("Apps")));
      //  driver.findElement(MobileBy.AccessibilityId("Apps")).click();
        //List<WebElement>  elements = driver.findElements(By. className("android.widget.TextView"));
        //elements.get(1).click();

        driver.findElement(By.name("Contact Manager")).click();
        driver.findElement(By.name("Add Contact")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("liming");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("123456789");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys("liming@126.com");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();
        driver.findElement(By.id("android:id/button1h")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("liming");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("123456789");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys("liming@126.com");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();

        //click on 'Accessibility Node Querying' link
       // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility Node Querying")));
       // driver.findElement(MobileBy.AccessibilityId("Accessibility Node Querying")).click();
//back
     //   driver.navigate().back();
//back
       // driver.navigate().back();
    }
}