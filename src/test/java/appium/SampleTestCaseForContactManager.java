package appium;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SampleTestCaseForContactManager extends DriverBaseTest{
    //Test Annotation changes any java function to TestNG test case
    @Test
    public void sampleTest() throws Exception{
        //driver.findElement(By.name("Contact Manager")).click();
        //driver.findElement(By.name("Add Contact")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("liming");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("123456789");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys("liming@126.com");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();
        driver.findElement(By.id("android:id/button1h")).click();


    }
}