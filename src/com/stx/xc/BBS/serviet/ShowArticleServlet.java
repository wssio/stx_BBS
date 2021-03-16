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

@WebServlet("/article/show")
public class ShowArticleServlet extends HttpServlet {
    ArticleDao articleDao = new ArticleDao();
    CommentDao commentDao = new CommentDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String articleId = request.getParameter("id");


        //获取浏览次数
        int lookNumber = commentDao.lookNumber(articleId);
        //更新浏览次数
        lookNumber=lookNumber+1;
        commentDao.updateLookNumber(lookNumber,articleId);


        //获取文章内容
        Article article =articleDao.getArtileById(articleId);
        request.setAttribute("article",article);




        //获取评论列表
        ArrayList<Comment> comments = commentDao.getCommentById(articleId);
        request.setAttribute("comments",comments);

        //获取当前用户
        String login_user = request.getParameter("login_user");
        request.setAttribute("login_user",login_user);

        request.getRequestDispatcher("/article_show.jsp").forward(request, response);
    }
}
