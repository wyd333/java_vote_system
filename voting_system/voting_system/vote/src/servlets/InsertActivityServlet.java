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
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-24
 * Time: 17:49
 */
@WebServlet("/insertActivityServlet")
public class InsertActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=UTF-8");
        //从session中获取图片信息
        Object acImg = req.getSession().getAttribute("acImg");
        if(acImg == null) {
            //上传失败
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("message", "202");
            resp.getWriter().println(JSON.toJSONString(userMap));   //直接回调
            return;
        }

        //上传成功
        //从req中获取表单中提交过的数据
        Activity ac = new Activity();
        ac.setAname(req.getParameter("aname"));
        ac.setAtype(Integer.parseInt(req.getParameter("atype")));
        ac.setAtotals(Integer.parseInt(req.getParameter("atotals")));
        ac.setAstartTime(req.getParameter("astartTime"));
        ac.setAendTime(req.getParameter("aendTime"));
        ac.setAvotespd(Integer.parseInt(req.getParameter("avotespd")));
        ac.setAdesc(req.getParameter("adesc"));
        ac.setAimg(acImg.toString());

        //调用service中的方法把数据保存到数据库中
        ActivityService ser = new ActivityServiceImpl();
        Map<String, Object> map = ser.insertActivity(ac);
        resp.getWriter().println(JSON.toJSONString(map));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
