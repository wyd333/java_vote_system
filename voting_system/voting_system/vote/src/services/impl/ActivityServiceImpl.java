package services.impl;

import bean.Activity;
import dao.ActivityDao;
import dao.impl.ActivityDaoImpl;
import services.ActivityService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-23
 * Time: 21:28
 */
public class ActivityServiceImpl implements ActivityService {
    ActivityDao dao = new ActivityDaoImpl();

    @Override
    public Map<String, Object> getAllActivities()  {
        Map<String,Object> activityMap = new HashMap<>();
        try {
            List<Activity> allActivities = dao.getAllActivities();
            if(allActivities != null) {
                activityMap.put("message", "200");
                activityMap.put("data", allActivities);
            }else{
                activityMap.put("message", "202");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return activityMap;
    }

    @Override
    public Map<String, Object> insertActivity(Activity activity) {
        Map<String,Object> activityMap = new HashMap<>();

        try {
            int i = dao.insertActivities(activity);
            if(i >= 1) {
                activityMap.put("message", "200");
            }else{
                activityMap.put("message", "202");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return activityMap;
    }

    @Override
    public Map<String, Object> deleteActivitiesByAid(int aid) {
        Map<String,Object> activityMap = new HashMap<>();

        try {
            int i = dao.deleteActivitiesByAid(aid);
            if(i >= 1) {
                activityMap.put("message", "200");
                //重新请求数据
            }else{
                activityMap.put("message", "202");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return activityMap;
    }

    @Override
    public Map<String, Object> getOneActivityByAid(int aid) {
        Map<String,Object> activityMap = new HashMap<>();
        try {
            Activity ac = dao.getOneActivityByAid(aid);
            if(ac == null) {
                activityMap.put("message", "202");
            }else{
                activityMap.put("message", "200");
                activityMap.put("data",ac);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return activityMap;
    }

    @Override
    public Map<String, Object> updateActivity(Activity activity) {
        Map<String,Object> activityMap = new HashMap<>();

        try {
            int i = dao.updateActivityByAid(activity);
            if(i >= 1) {
                activityMap.put("message", "200");
            }else{
                activityMap.put("message", "202");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return activityMap;
    }
}
