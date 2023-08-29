package dao.impl;

import bean.Candidate;
import dao.CandidateDao;
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
 * Date: 2023-05-27
 * Time: 15:29
 */
public class CandidateDaoImpl implements CandidateDao {
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet set = null;
    @Override
    public List<Candidate> getAllCandidatesByAid(int aid) throws SQLException {
        List<Candidate> list = new ArrayList<>();
        
        con = BaseUtil.getCon();
        String sql = "SELECT * FROM `candidate` WHERE aid = ?";
        statement = con.prepareStatement(sql);
        statement.setInt(1, aid);
        set = statement.executeQuery();
        while(set.next()) {
            Candidate can = new Candidate();
            can.setAid(set.getInt("aid"));
            can.setCanid(set.getInt("canid"));
            can.setCanavatar(set.getString("canavatar"));
            can.setCandesc(set.getString("candesc"));
            can.setCanname(set.getString("canname"));
            can.setCannum(set.getInt("cannum"));
            list.add(can);
        }
        return list;
    }
}
