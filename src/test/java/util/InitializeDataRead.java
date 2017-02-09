package util;

import java.io.IOException;

/**
 * Created by mengfeifei on 2016/12/30.
 */
public class InitializeDataRead {

    public Object[][] login() throws IOException {
        return ReadExcelPOI.getTestData("D:\\TestingForAiXuepaiData", "TestDataInitial.xls", "data");
    }

}
