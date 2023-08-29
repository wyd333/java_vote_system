package services.impl;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import services.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-15
 * Time: 13:22
 */
public class UserServiceImpl implements UserService {
    //定义dao层中的对象
    UserDao userDao = new UserDaoImpl();
    @Override
    public Map<String, Object> getUserByUnameAndUpwd(String uname, String upwd) {
        Map<String, Object> userMap = new HashMap<>();
        try {
            User user = userDao.getUserByUnameAndUpwd(uname, upwd);
            // 状态码，方便前端使用
            //判断成功或失败
            if(user != null) {
                userMap.put("message", "200");  //成功 状态码
                userMap.put("data", user);
            }else{
                userMap.put("message", "202");
                userMap.put("data", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userMap;
    }

    @Override
    public Map<String, Object> insertUser(String uname, String upwd, String unickname) {
        Map<String, Object> userMap = new HashMap<>();

        try {
            int i = userDao.getUserByName(uname);
            //如果i==1，则证明数据库中已经存在该账号了，就不能再保存了
            if(i >= 1){
                userMap.put("message", "201");  //账号已存在

            }else{
                //账号不存在 可以注册
                Integer integer = userDao.insertUser(uname, upwd, unickname);
                if(integer > 0) {
                    //成功
                    userMap.put("message", "200");  //账号已存在
                }else{
                    userMap.put("message", "202");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userMap;
    }
}
