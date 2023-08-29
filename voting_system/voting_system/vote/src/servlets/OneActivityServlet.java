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
 * Date: 2023-05-25
 * Time: 14:26
 */
@WebServlet("/oneActivityServlet")
public class OneActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=UTF-8");

        int aid = Integer.parseInt(req.getParameter("aid"));
//        System.out.println(aid);
        ActivityService ser = new ActivityServiceImpl();
        Map<String, Object> map = ser.getOneActivityByAid(aid);
        resp.getWriter().println(JSON.toJSONString(map));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
