package chatroom.controller;

import chatroom.dao.DB;
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
@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = MyTools.toChinese(request.getParameter("username"));
        String password = request.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setTime(new Date());
        DB con = new DB();
        con.createCon();
        String sql = String.format("SELECT * FROM users WHERE name = '%s'", user.getName());
        ResultSet resultSet = con.executeQuery(sql);
        try {
            if(resultSet.next()){
                if(resultSet.getString(2).equals(user.getPassword())){
                    //登录成功
                    resultSet.close();
                    con.close();
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                    ServletContext application = request.getServletContext();
                    ArrayList<User> users = (ArrayList<User>) application.getAttribute("users");
                    if (users == null){
                        users = new ArrayList<>();
                        users.add(user);
                        application.setAttribute("users",users);
                    }else {
                        boolean isOnlineNow = false;
                        for(int i = 0; i < users.size(); i++){
                            User everyUser = users.get(i);
                            if (everyUser.getName().equals(user.getName())){
                                isOnlineNow = true;
                                break;
                            }
                        }
                        if (!isOnlineNow){
                            users.add(user);
                            application.setAttribute("users",users);
                        }
                    }
                    System.out.println("在线人员："+ Arrays.toString(new ArrayList[]{(ArrayList) application.getAttribute("users")}));

                    response.sendRedirect("main.jsp");
                }else {
                    //登录失败，密码错误，重新登录
                    response.sendRedirect("login.jsp?error=yes");
                }
            }else {
                //账号不存在，应该去注册或者重新登录
                response.sendRedirect("index.jsp?error=yes");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
