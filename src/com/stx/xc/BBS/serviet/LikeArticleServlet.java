package com.stx.xc.BBS.serviet;

import com.stx.xc.BBS.dao.ArticleDao;
import com.stx.xc.BBS.dao.LIkeArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/like/article")
public class LikeArticleServlet extends HttpServlet {
    LIkeArticleDao lIkeArticleDao = new LIkeArticleDao();
    ArticleDao articleDao = new ArticleDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String like_user = request.getParameter("like_user");

        int yesAndNo = lIkeArticleDao.lookLikeArticle(id,like_user);
//        System.out.println("此用户有点赞此文章吗？:"+yesAndNo);
        int likeCount = lIkeArticleDao.haveLike(id);
//        System.out.println("这篇文章有:"+likeCount+"个点赞。");

        if (yesAndNo==0){
            likeCount=likeCount+1;
            lIkeArticleDao.addLikeArticle(id,like_user);
//            System.out.println("为此用户点赞此文章。");
            articleDao.updateLike(likeCount,id);
//            System.out.println("现在文章有多少个赞？"+lIkeArticleDao.haveLike(id));

        }else{
            likeCount=likeCount-1;
            lIkeArticleDao.deleteLikeArticle(id,like_user);
//            System.out.println("此用户取消点赞此文章。");
            articleDao.updateLike(likeCount,id);
//            System.out.println("现在文章有多少个赞？"+lIkeArticleDao.haveLike(id));
        }


        response.sendRedirect("/intel");
    }
}
