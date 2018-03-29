package chatroom.controller;

import chatroom.dao.DB;
import chatroom.model.User;
import chatroom.model.UserContent;
import chatroom.util.MyTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by jal on 2018/3/28 0028.
 */
@WebServlet(name = "receiveServlet")
public class ReceiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("程序执行到此处1");
        String content = MyTools.toChinese(request.getParameter("content"));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + content+" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String time = MyTools.changeTime(new Date());//此处记得修改！改成日期类型
        UserContent userContent = new UserContent();
        System.out.println("程序执行到此处2");
        userContent.setName(user.getName());
        userContent.setContent(content);
        userContent.setTime(time);
        System.out.println("程序执行到此处3");
        DB con = new DB();
        con.createCon();
        String sql = String.format("insert into contents (name,content,time) values('%s','%s','%s')", userContent.getName(), userContent.getContent(), userContent.getTime());
        con.executeUpdate(sql);
        con.close();
        response.sendRedirect("main.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
