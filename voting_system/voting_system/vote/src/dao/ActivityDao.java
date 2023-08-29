package dao;

import bean.Activity;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-23
 * Time: 20:58
 */
public interface ActivityDao {
    public List<Activity> getAllActivities() throws SQLException;
    public int insertActivities(Activity activity) throws SQLException;
    public int deleteActivitiesByAid(int aid) throws SQLException;
    public Activity getOneActivityByAid(int aid) throws SQLException;
    public int updateActivityByAid(Activity activity) throws SQLException;
}
