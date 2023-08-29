package servlets;

import com.alibaba.fastjson.JSON;
import services.UserService;
import services.impl.UserServiceImpl;

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
 * Time: 11:13
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=UTF-8");
        //进行数据处理
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        String unickname = req.getParameter("unickname");
        System.out.println(uname+" "+upwd+" "+unickname);
        //存入数据库中
        UserService service = new UserServiceImpl();
        Map<String, Object> map = service.insertUser(uname, upwd, unickname);
        //转成json，响应到html
        String jsonString = JSON.toJSONString(map);
        resp.getWriter().print(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
