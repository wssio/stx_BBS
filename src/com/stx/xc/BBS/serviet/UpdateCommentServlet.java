package com.stx.xc.BBS.serviet;

import com.stx.xc.BBS.dao.ArticleDao;
import com.stx.xc.BBS.dao.CommentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update/comment")
public class UpdateCommentServlet extends HttpServlet {
    ArticleDao articleDao = new ArticleDao();
    CommentDao commentDao = new CommentDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获取修改数据
        String updateCommentID = request.getParameter("updateCommentID");
        String updateComment = request.getParameter("updateIdea");

        //执行修改
        commentDao.updateComment(updateCommentID, updateComment);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
