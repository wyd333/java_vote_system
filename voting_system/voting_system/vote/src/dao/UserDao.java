package dao;

import bean.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-15
 * Time: 10:06
 */
public interface UserDao {
    //登陆查询
    public User getUserByUnameAndUpwd(String uname, String upwd) throws Exception;
    //查询账号是否存在
    public int getUserByName(String name) throws Exception;
    //插入一条user数据
    public Integer insertUser(String uname,String upwd,String unickname) throws Exception;
}
