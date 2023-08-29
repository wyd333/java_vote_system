package services;

import bean.Activity;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-23
 * Time: 21:20
 */
public interface ActivityService {
    public Map<String,Object> getAllActivities();
    public  Map<String, Object>  insertActivity(Activity activity);
    public Map<String, Object> deleteActivitiesByAid(int aid);
    public Map<String, Object> getOneActivityByAid(int aid);
    public Map<String, Object> updateActivity(Activity activity);
}
