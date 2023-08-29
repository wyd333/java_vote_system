package services.impl;

import bean.Candidate;
import dao.CandidateDao;
import dao.impl.CandidateDaoImpl;
import services.CandidateService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-27
 * Time: 15:43
 */
public class CandidateServiceImpl implements CandidateService {
    CandidateDao dao = new CandidateDaoImpl();
    @Override
    public Map<String, Object> getAllCandidatesByAid(int aid) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Candidate> list = dao.getAllCandidatesByAid(aid);
            if(list == null) {
                map.put("message","202");
            }else{
                map.put("message","200");
                map.put("data", list);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
