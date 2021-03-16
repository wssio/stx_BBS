package com.stx.xc.BBS.serviet;

import com.stx.xc.BBS.dao.ArticleDao;
import com.stx.xc.BBS.dao.CommentDao;
import com.stx.xc.BBS.entity.Article;
import com.stx.xc.BBS.entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/add/comment")
public class AddCommentServlet extends HttpServlet {

    CommentDao commentDao = new CommentDao();
    ArticleDao articleDao = new ArticleDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取当前用户
        String login_user = request.getParameter("login_user");
        //获取评论
        String addComment = request.getParameter("addComment");
        //获取文章id
        String ArticleId = request.getParameter("pLArticle");

        //添加评论
        if((addComment!=null)&&(addComment!="")){
            commentDao.addComment(ArticleId, login_user, addComment);
        }
        //查询有多少个评论
        int haveComment = commentDao.haveComment(ArticleId);
        //查到后更新article表
        articleDao.updateComment(haveComment,ArticleId);

        //获取文章内容
        Article article = articleDao.getArtileById(ArticleId);
        request.setAttribute("article", article);

        //获取评论列表
        ArrayList<Comment> comments = commentDao.getCommentById(ArticleId);
        request.setAttribute("comments", comments);

        request.setAttribute("login_user", login_user);

        request.getRequestDispatcher("/article_show.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
