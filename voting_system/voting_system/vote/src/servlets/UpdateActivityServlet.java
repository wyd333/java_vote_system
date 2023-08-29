package servlets;

import bean.Activity;
import com.alibaba.fastjson.JSON;
import services.ActivityService;
import services.impl.ActivityServiceImpl;

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
 * Date: 2023-05-24
 * Time: 17:49
 */
@WebServlet("/updateActivityServlet")
public class UpdateActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=UTF-8");
        //从req中获取表单中提交过的数据
        Activity ac = new Activity();
        ac.setAid(Integer.parseInt(req.getParameter("aid")));
        ac.setAname(req.getParameter("aname"));
        ac.setAtype(Integer.parseInt(req.getParameter("atype")));
        ac.setAtotals(Integer.parseInt(req.getParameter("atotals")));
        ac.setAstartTime(req.getParameter("astartTime"));
        ac.setAendTime(req.getParameter("aendTime"));
        ac.setAvotespd(Integer.parseInt(req.getParameter("avotespd")));
        ac.setAdesc(req.getParameter("adesc"));
        //把新提交的数据，对数据库中的数据进行更新
        ActivityService ser = new ActivityServiceImpl();
        Map<String, Object> map = ser.updateActivity(ac);

        resp.getWriter().print(JSON.toJSONString(map));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
