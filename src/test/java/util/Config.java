package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * Created by mengfeifei on 2017/5/24.
 */
public class Config {
    static final String CONFIG_FILE= "src/ios_config.properties";
    static final String fileNamePath =Config.CONFIG_FILE;
    private static Config testResManager ;
    public static Config getInstance(){
        if(testResManager==null){
            testResManager= new Config();
            System.out.println("getInstance");
        }
        return testResManager;
    }

    public static String getCfg(String key)throws IOException {
        Properties props = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(fileNamePath);
            // 如果将in改为下面的方法，必须要将.Properties文件和此class类文件放在同一个包中
            //in = propertiesTools.class.getResourceAsStream(fileNamePath);
            props.load(in);
            String value = props.getProperty(key);
            //System.out.println("获取"+key+"的value："+value);
            // 有乱码时要进行重新编码
            //new String(props.getProperty("name").getBytes("ISO-8859-1"), "GBK");
            //System.out.println(key+"="+value);
            return value;

        } catch (IOException e) {
            e.printStackTrace();
            return null;

        } finally {
            if (null != in)
                in.close();
        }
    }

}
