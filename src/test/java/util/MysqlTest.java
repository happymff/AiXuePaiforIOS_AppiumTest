package util;

/**
 * Created by mff on 2017/5/15.
 */

import java.sql.*;
public class MysqlTest {
    public static void main(String[] args){
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名students
        String url = "jdbc:mysql://192.168.8.138/database1";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password = "1234";
        String runResult;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 连接数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            // statement用来执行SQL语句
            String s1 = "\"util.Test15\",\"testAssert1\",\"2017-05-17 11:41:11\",\"9毫秒\",\"SUCCESS\"";
            String sql1 = "insert into testngResult1 values("+s1+")";
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            //statement1.setInt(1,11);
            int count = statement1.executeUpdate();
            if (count > 0) {
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败！");
            }
            Statement statement = conn.createStatement();
            // 要执行的SQL语句
            String sql = "select * from testngResult1";
            // 结果集
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())  {
                // 选择id这列数据
                runResult = rs.getString("runResult");
                // 输出结果
                System.out.println(rs.getString("runResult") + "\t" + runResult);
            }
            rs.close();
            conn.close();
        }catch(ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}