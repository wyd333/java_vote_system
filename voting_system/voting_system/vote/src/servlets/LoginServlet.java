package servlets;

import com.alibaba.fastjson.JSON;
import services.UserService;
import services.impl.UserServiceImpl;

import javax.jws.WebService;
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
 * Date: 2023-05-18
 * Time: 8:49
 */

/*
    怎么把一个类转成servlet？
    只需继承HttpServlet类即可
    HttpServlet类要先导包
 */

    @WebServlet("/login") //起一个别名 可以被url找到（网名）

public class LoginServlet extends HttpServlet {
    /*
    重写两个方法
    get请求：把用户输入的数据拼接在url地址后面  一般用于查询
    post请求：把用户输入的数据隐藏在请求头中  post请求只能通过表单发起
     */

    //doGet就是处理前端页面传递过来的get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        UserService ser = new UserServiceImpl();
        System.out.println("我是get请求");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 跳转过来，怎么在当前的servlet中获取到html中提交过的数据？
        //        System.out.println("我是post请求");
        String uname = req.getParameter("uname");   //根据表单的属性值获取值
        String upwd = req.getParameter("upwd");
        System.out.println("uname:" + uname);
        System.out.println("upwd:" + upwd);
        // 调用service层进行登陆业务的处理
        UserService ser = new UserServiceImpl();
        Map<String, Object> map = ser.getUserByUnameAndUpwd(uname, upwd);
//        // 把数据转成json格式->api数据接口
//        String jsonString = JSON.toJSONString(map);
//        // 响应给页面
//        resp.getWriter().println(jsonString);
        if(map.get("message").equals("200")) {
            //登陆成功后，把当前的用户信息保存到session对象
            req.getSession().setAttribute("user",map);
            resp.sendRedirect("index.html");
        }else{
            resp.sendRedirect("login.html");
        }
    }
}
