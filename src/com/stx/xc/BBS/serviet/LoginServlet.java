package com.stx.xc.BBS.serviet;

import com.stx.xc.BBS.dao.UserDao;
import com.stx.xc.BBS.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDao.queryUserByName(username);


        Boolean exist = false;
        String errorMsg = "0";
        if (user != null) {
            if (user.getPassword().equals(password)) {
                exist = true;
            } else {
                exist = false;
                errorMsg = "2";
            }
        } else {
            exist = false;
            errorMsg = "1";
        }

        if (exist) {
            HttpSession session = request.getSession();
            session.setAttribute("login_user", user);
            //登录成功后记录登录信息
            response.sendRedirect("/intel");
        } else {
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("/loginAndRegister.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        if (status!=null){
            if (status.equals("quit")) {
                String username = null;
                HttpSession session = request.getSession();
                session.setAttribute("login_user", username);
                //登录成功后记录登录信息
                response.sendRedirect("/intel");
            }else{
                System.out.println("intel页面get方法获取status参数错误！");
                response.sendRedirect("/loginAndRegister.jsp");
            }
        }else {
            response.sendRedirect("/loginAndRegister.jsp");
        }

    }


}
