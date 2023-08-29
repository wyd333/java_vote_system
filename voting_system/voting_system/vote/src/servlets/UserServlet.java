package servlets;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-22
 * Time: 11:44
 */
@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");  //设置html提交到servlet中
        resp.setContentType("text/json;charset=utf-8"); //servlet相应给html
        //进行的数据的处理
        //从session中获取当前的登录的用户信息
        Object user = req.getSession().getAttribute("user");    //根据键找到值
        //把user转成一个json字符串
        String jsonString = JSON.toJSONString(user);
        //响应给前端
        resp.getWriter().print(jsonString);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
