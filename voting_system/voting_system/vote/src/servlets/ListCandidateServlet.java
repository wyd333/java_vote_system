package servlets;

import bean.Candidate;
import com.alibaba.fastjson.JSON;
import services.CandidateService;
import services.impl.CandidateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-27
 * Time: 15:48
 */
@WebServlet("/listCandidateServlet")
public class ListCandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=UTF-8");
        //从前端获取用户提交的hid
        int aid = Integer.parseInt(req.getParameter("aid"));
        //调用service层
        CandidateService ser = new CandidateServiceImpl();
        Map<String, Object> map = ser.getAllCandidatesByAid(aid);
        resp.getWriter().println(JSON.toJSONString(map));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
