package util;

/**
 * Created by mff on 2017/5/17.
 */

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NewReport1 implements IReporter{

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        List<ITestResult> list = new ArrayList<ITestResult>();
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult suiteResult : suiteResults.values()) {
                ITestContext testContext = suiteResult.getTestContext();
                IResultMap passedTests = testContext.getPassedTests();
                IResultMap failedTests = testContext.getFailedTests();
                IResultMap skippedTests = testContext.getSkippedTests();
                IResultMap failedConfig = testContext.getFailedConfigurations();
                list.addAll(this.listTestResult(passedTests));
                list.addAll(this.listTestResult(failedTests));
                list.addAll(this.listTestResult(skippedTests));
                list.addAll(this.listTestResult(failedConfig));
            }
        }
        this.sort(list);
        this.outputResult(list, outputDirectory+"/test.txt");
    }

    private ArrayList<ITestResult> listTestResult(IResultMap resultMap){
        Set<ITestResult> results = resultMap.getAllResults();
        return new ArrayList<ITestResult>(results);
    }

    private void sort(List<ITestResult> list){
        Collections.sort(list, new Comparator<ITestResult>() {
            @Override
            public int compare(ITestResult r1, ITestResult r2) {
                if(r1.getStartMillis()>r2.getStartMillis()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
    }

    private void outputResult(List<ITestResult> list, String path){
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(new File(path)));
            StringBuffer sb = new StringBuffer();
            for (ITestResult result : list) {
                if(sb.length()!=0){
                    sb.append("\r\n");
                }
                sb.append("\"")
                        .append(result.getTestClass().getRealClass().getName())
                        .append("\",\"")
                        .append(result.getMethod().getMethodName())
                        .append("\",\"")
                        .append(this.formatDate(result.getStartMillis()))
                        .append("\",\"")
                        .append(result.getEndMillis()-result.getStartMillis())
                        .append("毫秒\",\"")
                        .append(this.getStatus(result.getStatus()))
                        .append("\"");
            }
            output.write(sb.toString());
            MysqlConnect mysqlConnect = new MysqlConnect();
            String s = sb.toString();
            //System.out.println(s);
            mysqlConnect.connectMysql(s);
            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getStatus(int status){
        String statusString = null;
        switch (status) {
            case 1:
                statusString = "SUCCESS";
                break;
            case 2:
                statusString = "FAILURE";
                break;
            case 3:
                statusString = "SKIP";
                break;
            default:
                break;
        }
        return statusString;
    }

    private String formatDate(long date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

}
