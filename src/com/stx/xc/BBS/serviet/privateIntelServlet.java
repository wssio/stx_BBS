package com.stx.xc.BBS.serviet;

import com.stx.xc.BBS.dao.ArticleDao;
import com.stx.xc.BBS.dao.UserDao;
import com.stx.xc.BBS.entity.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/intel/private")
public class privateIntelServlet extends HttpServlet {

    UserDao userDao = new UserDao();
    ArticleDao articleDao = new ArticleDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取查询对象id
        String userId = request.getParameter("userId");


        //获取文章列表
        ArrayList<Article> articles = articleDao.queryAllArticlesById(userId);
        request.setAttribute("articles",articles);

        //获取当前时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String dateHH = format.format(date);
        request.setAttribute("systemDate",dateHH);

        request.getRequestDispatcher("/privateIntel.jsp").forward(request,response);
    }
}
