package DataProvider;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import util.ReadExcelPOI;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class DataProvid {

    @DataProvider(name = "DriverInitialize")
    public static Object[][] driverInitialize() throws IOException {
        return ReadExcelPOI.getTestData("/Users/mff/Documents/TestData/TestingForAiXuepaiData", "TestData.numbers", "data");
    }
    @DataProvider(name = "LoginSucess")
    public static Object[][] loginsucess() {
        return new Object[][] {
                new Object[] { "爱学派D", "a11111" }
        };
    }
    @DataProvider(name = "StudentLogin")
    public static Object[][] studentloginsucess() {
        return new Object[][] {
                new Object[] { "AXPC11@ett.com", "a11111" }
        };
    }
}
