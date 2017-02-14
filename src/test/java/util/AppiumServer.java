package util;

import com.sun.tools.javac.util.Log;

import java.io.IOException;

/**
 * Created by mengfeifei on 2017/2/13.
 */
public class AppiumServer {
    //Log log = new Log();
   // LogUtil log = new LogUtil();

    public AppiumServer() {
        KillTask("node.exe");
       // log.printRawLines("init appium server...");
       // log.info("init appium server...");
        System.out.println("init appium server...");
    }

    public void KillTask(String taskname) {
        String Command = "taskkill /F /im " + taskname;
        //log.printRawLines("kill "+ taskname + " task ...");
        //log.info("kill " + taskname + " task ...");
        System.out.println("kill " + taskname + " task ...");
        runCommand(Command);
    }

    public void runServer(int port, String udid) {
        //log.info("run " + udid + " Appium Server in port " + port + "...");
        int bpport = port + 1;
        int chromeport = port + 4792;
        //多设备server端需要手动指定每台设备的udid,安卓无线连接下就是设备的ip:port..
        String Command = "appium.cmd -p " + port + " -bp " + bpport + " --session-override --chromedriver-port " + chromeport + " -U "
                + udid + " >c://" + port + ".txt";
       // log.info(Command);
        System.out.println(Command);
        runCommand(Command);
    }

    private void runCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch ( java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
