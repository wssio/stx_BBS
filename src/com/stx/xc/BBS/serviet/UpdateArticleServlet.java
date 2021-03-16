package com.stx.xc.BBS.serviet;

import com.stx.xc.BBS.dao.ArticleDao;
import com.stx.xc.BBS.entity.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/article/modify")
public class UpdateArticleServlet extends HttpServlet {
    ArticleDao articleDao = new ArticleDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String summary = request.getParameter("summary");
        String content = request.getParameter("content");
        String aid = request.getParameter("id");

        articleDao.updateArticle(aid,title,summary,content);
        response.sendRedirect("/intel");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("id");
        Article article = articleDao.getArtileById(aid);

        request.setAttribute("article",article);
        request.getRequestDispatcher("/artcle_form.jsp").forward(request,response);
    }
}
