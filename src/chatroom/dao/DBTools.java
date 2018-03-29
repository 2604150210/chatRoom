package chatroom.dao;

import chatroom.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jal on 2018/3/26 0026.
 */
public class DBTools {
    static void Register(HttpServletRequest request, HttpServletResponse response,ResultSet resultSet, User user) throws SQLException, IOException {

            response.sendRedirect("error.jsp");

    }
}
