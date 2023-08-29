package dao.impl;

import bean.User;
import dao.UserDao;
import util.BaseUtil;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-15
 * Time: 10:12
 */
public class UserDaoImpl implements UserDao {
    //把对象声明成成员变量
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet set = null;

    @Override
    public User getUserByUnameAndUpwd(String uname, String upwd) throws Exception {
        con = BaseUtil.getCon();
        String sql = "select * from user where uname = ? and upwd = ?";
        statement = con.prepareStatement(sql);
        //替换占位符
        statement.setString(1, uname);
        statement.setString(2, upwd);
        //执行
         set = statement.executeQuery();
        while(set.next()) {
            User user = new User();
            user.setUname(set.getString("uname"));
            user.setUpwd(set.getString("upwd"));
            user.setUid(set.getInt("uid"));
            user.setUnickname(set.getString("unickname"));
            return user;
        }
        BaseUtil.closeCon(con);
        return null;
    }

    @Override
    public int getUserByName(String uname) throws Exception{
        con = BaseUtil.getCon();
        String sql = "select count(uid) from user where uname = ?";
        statement = con.prepareStatement(sql);
        statement.setString(1, uname);
        //执行
        set = statement.executeQuery();
        if(set.next()) {
            return set.getInt(1);
        }
        BaseUtil.closeCon(con);
        return 0;
    }

    @Override
    public Integer insertUser(String uname, String upwd, String unickname) throws Exception {
        con = BaseUtil.getCon();
        String sql = "insert into user(uname,upwd,unickname) VALUES (?,?,?)";
        statement = con.prepareStatement(sql);
        statement.setString(1, uname);
        statement.setString(2, upwd);
        statement.setString(3, unickname);
        return statement.executeUpdate();
    }
}
