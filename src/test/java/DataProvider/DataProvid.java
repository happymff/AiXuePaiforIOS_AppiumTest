package DataProvider;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import util.ReadExcelJXL;
import util.ReadExcelPOI;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class DataProvid {


    @DataProvider(name = "DriverInitialize")
    public static Object[][] driverInitialize() throws IOException {
        return ReadExcelPOI.getTestData("/Users/mff/Documents/TestData/TestingForAiXuepaiData", "TestData.numbers", "data");
    }
    @DataProvider(name = "SeleniumTest")
    public static Object[][] getData() throws IOException {
        ReadExcelJXL readExcelJXL = new ReadExcelJXL();
        return readExcelJXL.getTestData("/Users/mff/Desktop/workspace", "TestData.xls", "data");
    }
    @DataProvider(name = "LoginSucess")
    public static Object[][] loginsucess() {
        return new Object[][] {
                new Object[] { "爱学派FF", "a11111" ,"9.3.3"}
        };
    }
    @DataProvider(name = "TeacherYun")
    public static Object[][] teacherLoginsucess() {
        return new Object[][] {
                new Object[] { "YunFF", "a11111" }
        };
    }
    @DataProvider(name = "StudentLogin2")
    public static Object[][] student2loginsucess() {
        return new Object[][] {
                new Object[] { "s2forff", "a11111" }
        };
    }
    @DataProvider(name = "StudentLogin1")
    public static Object[][] student1loginsucess() {
        return new Object[][] {
                new Object[] { "s1forff11", "a11111","feifei", "1111110111111111111"}
        };
    }
}
