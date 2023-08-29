package test;

import bean.Activity;
import bean.Candidate;
import bean.User;
import dao.ActivityDao;
import dao.CandidateDao;
import dao.UserDao;
import dao.impl.ActivityDaoImpl;
import dao.impl.CandidateDaoImpl;
import dao.impl.UserDaoImpl;
import services.UserService;
import services.impl.UserServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-15
 * Time: 11:12
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        UserDao dao = new UserDaoImpl();
//        User zhangsan = dao.getUserByUnameAndUpwd("zhangsan", "123456");
//        System.out.println(zhangsan);

//        UserService ser = new UserServiceImpl();
//        Map<String, Object> zhangsan = ser.getUserByUnameAndUpwd("zhangsan","123456");
//        System.out.println(zhangsan);
//        UserDao dao = new UserDaoImpl();
//        int zhangsan = dao.insertUser("wangwu","123","王五");
//        System.out.println(zhangsan);

//        UserService ser = new UserServiceImpl();
//        Map<String, Object> map = ser.insertUser("lisi", "123", "abc");
//        System.out.println(map.get("message"));
//        ActivityDao dao = new ActivityDaoImpl();
//        List<Activity> allActivities = dao.getAllActivities();
//        for (Activity activity: allActivities) {
//            System.out.println(activity);
////        }
//        Activity oneActivityByAid = dao.getOneActivityByAid(17);
//        System.out.println(oneActivityByAid);
        CandidateDao dao = new CandidateDaoImpl();
        List<Candidate> ret = dao.getAllCandidatesByAid(1);
        for (Candidate candidate: ret) {
            System.out.println(candidate);
        }
    }
}
