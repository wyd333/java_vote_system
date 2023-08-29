package dao.impl;

import bean.Activity;
import dao.ActivityDao;
import util.BaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-23
 * Time: 21:00
 */
public class ActivityDaoImpl implements ActivityDao {
    //把对象声明成成员变量
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet set = null;

    @Override
    public List<Activity> getAllActivities() throws SQLException {
        List<Activity> activityList = new ArrayList<>();
        con = BaseUtil.getCon();
        String sql = "select * from activity";
        statement = con.prepareStatement(sql);
        ResultSet set = statement.executeQuery();
        while (set.next()) {
            Activity activity = new Activity();
            activity.setAid(set.getInt("aid"));
            activity.setAname(set.getString("aname"));
            activity.setAendTime(set.getString("aend_time"));
            activity.setAimg(set.getString("aimg"));
            activity.setAdesc(set.getString("adesc"));
            activity.setAvotespd(set.getInt("avotespd"));
            activity.setAstartTime(set.getString("astart_time"));
            activity.setAtotals(set.getInt("atotals"));
            activity.setAtype(set.getInt("atype"));
            activityList.add(activity);
                    
        }
        return activityList;
    }

    @Override
    public int insertActivities(Activity activity) throws SQLException {
        con = BaseUtil.getCon();
        String sql = "INSERT INTO `vote`.`activity` (`aname`, `atotals`, `astart_time`, `aend_time`, `avotespd`, `atype`, `adesc`, `aimg`) VALUES (?,?,?,?,?,?,?,?)";
        statement = con.prepareStatement(sql);
        statement.setString(1, activity.getAname());
        statement.setInt(2, activity.getAtotals());
        statement.setString(3,activity.getAstartTime());
        statement.setString(4,activity.getAendTime());
        statement.setInt(5,activity.getAvotespd());
        statement.setInt(6,activity.getAtype());
        statement.setString(7,activity.getAdesc());
        statement.setString(8,activity.getAimg());
        int i = statement.executeUpdate();
        BaseUtil.closeCon(con);
        return i;
    }

    @Override
    public int deleteActivitiesByAid(int aid) throws SQLException {
        con = BaseUtil.getCon();
        String sql = "DELETE FROM activity WHERE aid = ?";
        statement = con.prepareStatement(sql);
        statement.setInt(1,aid);
        int i = statement.executeUpdate();
        BaseUtil.closeCon(con);
        return i;
    }

    @Override
    public Activity getOneActivityByAid(int aid) throws SQLException {
        con = BaseUtil.getCon();
        String sql = "select * from activity where aid = ?";
        statement = con.prepareStatement(sql);
        statement.setInt(1,aid);
        ResultSet set = statement.executeQuery();
        if (set.next()) {
            Activity activity = new Activity();
            activity.setAid(set.getInt("aid"));
            activity.setAname(set.getString("aname"));
            activity.setAendTime(set.getString("aend_time"));
            activity.setAimg(set.getString("aimg"));
            activity.setAdesc(set.getString("adesc"));
            activity.setAvotespd(set.getInt("avotespd"));
            activity.setAstartTime(set.getString("astart_time"));
            activity.setAtotals(set.getInt("atotals"));
            activity.setAtype(set.getInt("atype"));
            return activity;
        }
        return null;
    }

    @Override
    public int updateActivityByAid(Activity activity) throws SQLException {
        con = BaseUtil.getCon();

        String sql = "UPDATE `vote`.`activity` SET `aname` = ?, `atotals` = ?, `astart_time` = ?, `aend_time` = ?, `avotespd` = ?, `atype` = ?, `adesc` = ?, `aimg` = ? WHERE `aid` = ?";
        statement = con.prepareStatement(sql);
        statement.setString(1, activity.getAname());
        statement.setInt(2, activity.getAtotals());
        statement.setString(3, activity.getAstartTime());
        statement.setString(4, activity.getAendTime());
        statement.setInt(5,activity.getAvotespd());
        statement.setInt(6,activity.getAtype());
        statement.setString(7, activity.getAdesc());
        statement.setString(8,activity.getAimg());
        statement.setInt(9,activity.getAid());
        int i = statement.executeUpdate();
        BaseUtil.closeCon(con);
        return i;
    }
}
