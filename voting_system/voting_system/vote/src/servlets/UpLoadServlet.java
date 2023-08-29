package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-26
 * Time: 16:32
 */
@WebServlet(value = "/upLoadServlet")
//接收上传的文件的请求头的配置
@MultipartConfig
public class UpLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //写在html中imgFile.set("imgFile",img);的key
        String random = UUID.randomUUID().toString(); //产生一个UUid
        Part part = req.getPart("imgFile"); //获取到上的文件
        //上传文件
        //设置上传路径
        String path = "D:\\apache-tomcat-8.5.38-windows-x64\\apache-tomcat-8.5.38\\webapps\\img\\"; //设置到tomcat中 充当一个静态资源服务器
        //开始上传
        part.write(path+random+part.getSubmittedFileName());

        //把图片的名称保存到session中，在插入活动时保存到相应的活动表格中
        req.getSession().setAttribute("acImg", random+part.getSubmittedFileName());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
