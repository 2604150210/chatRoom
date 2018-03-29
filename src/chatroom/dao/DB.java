package chatroom.dao;

import java.sql.*;

/**
 * Created by jal on 2018/3/26 0026.
 */
public class DB {
    private String url = "jdbc:mysql://192.168.1.108:3306/jal?useUnicode=true&characterEncoding=utf-8";
    private String driverClassName = "com.mysql.jdbc.Driver";
    private String username = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public DB(){
        try {
            Class.forName(driverClassName).newInstance();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("加载数据库驱动失败！");
        }
    }
    public void createCon(){
        try {
            connection = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("获取数据库连接失败");
        }
    }
    public void getStatement(){
        try {
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("创建Statement对象失败！");
        }
    }
    public boolean executeUpdate(String sql){
        boolean mark = false;
        try {
            getStatement();
            int iCount = statement.executeUpdate(sql);
            if (iCount > 0){
                mark = true;
            }else {
                mark = false;
            }
        }catch (Exception e){
            e.printStackTrace();
            mark = false;
        }
        return mark;
    }
    public void close()  {

        try {
            statement.close(); connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ResultSet executeQuery(String sql){
        ResultSet resultSet = null;
        try {
            getStatement();
            try {
                resultSet = statement.executeQuery(sql);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("查询数据库失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }
}
