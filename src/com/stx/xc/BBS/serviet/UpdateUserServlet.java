package com.stx.xc.BBS.serviet;

import com.stx.xc.BBS.dao.SystemDateDao;
import com.stx.xc.BBS.dao.UserDao;
import com.stx.xc.BBS.dao.UpdateUserDao;
import com.stx.xc.BBS.entity.SystemDate;
import com.stx.xc.BBS.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change/information")
public class UpdateUserServlet extends HttpServlet {

    UserDao userDao = new UserDao();
    SystemDateDao systemDateDao = new SystemDateDao();
    UpdateUserDao updateUserDao = new UpdateUserDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取要查询的用户
        String login_user = request.getParameter("login_user");
        String userSex = request.getParameter("userSex");


        //根据性别查头像
        SystemDate systemDate = systemDateDao.getPhotoCount(userSex);
        request.setAttribute("systemDate", systemDate.getValue());


        //根据要查询的用户信息
        User user = userDao.queryUserByName(login_user);

        //
        request.setAttribute("user", user);

        request.getRequestDispatcher("/changeInformation.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取更新数据
        String update_userId = request.getParameter("update_userId");
        String updateAvarat = request.getParameter("updateAvarat");
        String updateSex = request.getParameter("updateSex");
        String updateNickname = request.getParameter("nickname");
        String updatePassword = request.getParameter("passwordOne");

        if ((updateAvarat != null) || (updateAvarat != "")) {
            updateUserDao.updateAvarat(update_userId,updateAvarat);
        }
        if (updateSex != "2") {
            updateUserDao.updateSex(update_userId,updateSex);
        }
        if ((updateNickname != null) || (updateNickname != "")) {
            updateUserDao.updateNickname(update_userId,updateNickname);
        }
        if (updatePassword.length()>0) {
            System.out.println("密码："+updatePassword);
            updateUserDao.updatePassword(update_userId,updatePassword);
        }

        response.sendRedirect("/intel");
    }
}
