package services;

import bean.User;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-15
 * Time: 13:19
 */
public interface UserService {
    //按业务定义函数
    public Map<String, Object> getUserByUnameAndUpwd(String uname, String upwd);
    public Map<String, Object>insertUser(String uname, String upwd, String unickname);
}
