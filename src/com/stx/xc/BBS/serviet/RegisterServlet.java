package com.stx.xc.BBS.serviet;

import com.stx.xc.BBS.dao.UserDao;
import com.stx.xc.BBS.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String username = request.getParameter("username");
        String passwordOne = request.getParameter("passwordOne");
        String passwordTwo = request.getParameter("passwordTwo");
        String nickname = request.getParameter("nickname");
        Date date = new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyy年MM月dd日-HH时mm分ss秒");

        User user = userDao.queryUserByName(username);
        String hint = "0";
        if (user != null) {
            hint = "1";
        } else {
            if ((passwordOne.equals(passwordTwo)) && ((passwordOne.length()) != 0) && ((username.length()) != 0) && ((nickname.length()) != 0)) {
                userDao.insertUser(username, passwordOne, nickname);
                hint = "2";
            } else {
                hint = "3";
            }
        }
        request.setAttribute("hint", hint);
        request.getRequestDispatcher("/loginAndRegister.jsp").forward(request, response);
//        response.sendRedirect("/loginAndRegister");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/loginAndRegister.jsp").forward(request, response);

    }
}
