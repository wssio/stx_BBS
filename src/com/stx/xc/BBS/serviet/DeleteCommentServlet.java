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

@WebServlet("/comment/delete")
public class DeleteCommentServlet extends HttpServlet {

    CommentDao commentDao = new CommentDao();
    ArticleDao articleDao = new ArticleDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取评论id
        String commentId = request.getParameter("commentId");
        CommentDao.deleteByid(commentId);
        //查询有多少个评论
        String articleID = request.getParameter("articleID");
        int haveComment = commentDao.haveComment(articleID);
        //查到后更新article表
        articleDao.updateComment(haveComment,articleID);

        //获取文章内容
        Article article =articleDao.getArtileById(articleID);
        request.setAttribute("article",article);

        //获取评论列表
        ArrayList<Comment> comments = commentDao.getCommentById(articleID);
        request.setAttribute("comments",comments);

        //获取当前用户
        String login_user = request.getParameter("login_user");
        request.setAttribute("login_user",login_user);

        request.getRequestDispatcher("/article_show.jsp").forward(request, response);

    }
}
