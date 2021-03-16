package com.stx.xc.BBS.serviet;

import com.stx.xc.BBS.dao.ArticleDao;
import com.stx.xc.BBS.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/article/create")
public class AddArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String summary = request.getParameter("summary");
        String content = request.getParameter("content");
        User loginUser = (User) request.getSession().getAttribute("login_user");
        Integer userid = loginUser.getId();

        ArticleDao.insertArticle(title,summary,content,userid);
        response.sendRedirect("/intel");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/artcle_form.jsp").forward(request, response);

    }
}
