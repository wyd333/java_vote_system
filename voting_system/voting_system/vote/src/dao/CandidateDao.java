package dao;

import bean.Candidate;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-27
 * Time: 15:24
 */
public interface CandidateDao {
    public List<Candidate> getAllCandidatesByAid(int aid) throws SQLException;
}
