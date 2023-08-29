package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-15
 * Time: 11:22
 */
public class BaseUtil {
    //获取连接对象
    public static Connection getCon() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/vote?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8","root","000000");
    }

    //关闭连接对象
    public static void closeCon(Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
