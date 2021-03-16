package com.stx.xc.BBS.serviet;

import com.stx.xc.BBS.dao.UpdateUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete/user")
public class DeleteUserServlet extends HttpServlet {


    UpdateUserDao updateUserDao = new UpdateUserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String delete_user = request.getParameter("delete_user");

        updateUserDao.deketePassword(delete_user);
        String username = null;
        HttpSession session = request.getSession();
        session.setAttribute("login_user", username);

        response.sendRedirect("/intel");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
