package services;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-27
 * Time: 15:40
 */
public interface CandidateService {
    public Map<String, Object> getAllCandidatesByAid(int aid);
}
