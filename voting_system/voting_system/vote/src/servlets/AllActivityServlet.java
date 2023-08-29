package servlets;

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
 * Date: 2023-05-23
 * Time: 21:38
 */
@WebServlet("/allActivities")
public class AllActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=UTF-8");
        ActivityService ser = new ActivityServiceImpl();
        Map<String, Object> allActivities = ser.getAllActivities();
        String jsonString = JSON.toJSONString(allActivities);
        resp.getWriter().println(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
