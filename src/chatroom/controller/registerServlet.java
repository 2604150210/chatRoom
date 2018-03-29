package chatroom.controller;

import chatroom.dao.DB;
import chatroom.dao.DBTools;
import chatroom.model.User;
import chatroom.util.MyTools;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by jal on 2018/3/25 0025.
 */
@WebServlet(name = "registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getOutputStream().println("registerServlet");

        String name = MyTools.toChinese(request.getParameter("username"));
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        Date time = new Date();

        User user = new User();
        user.setName(name);
        user.setTime(time);
        user.setPassword(password);
        DB con = new DB();
        con.createCon();
        //  String sql = "SELECT * FROM users WHERE NAME = 'user'";
        String sql = String.format("SELECT * FROM users WHERE name = '%s'", user.getName());
       // System.out.println("sql1:"+sql);
        ResultSet resultSet = con.executeQuery(sql);
        try {
            if (resultSet.next()){
                response.sendRedirect("login.jsp?error=errgst");
            }
            else if(!password.equals(password2)){
                response.sendRedirect("register.jsp?error=errpsd");
            }else {
                sql = String.format("insert into users (name,password,time) values('%s','%s',%s)", user.getName(), user.getPassword(), null);
                con.executeUpdate(sql);
                //System.out.println("sql2:" + sql);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                ServletContext application = request.getServletContext();
                ArrayList<User> users = (ArrayList<User>) application.getAttribute("users");
                if (users == null) {
                    users = new ArrayList<>();
                    users.add(user);
                    application.setAttribute("users", users);
                } else {
                    boolean isOnlineNow = false;
                    for (int i = 0; i < users.size(); i++) {
                        User everyUser = users.get(i);
                        if (everyUser.getName().equals(user.getName())) {
                            isOnlineNow = true;
                            break;
                        }
                    }
                    if (!isOnlineNow) {
                        users.add(user);
                        application.setAttribute("users", users);
                    }
                    System.out.println("在线人员："+Arrays.toString(new ArrayList[]{(ArrayList) application.getAttribute("users")}));

                }
                response.sendRedirect("main.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
