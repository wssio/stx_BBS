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

@WebServlet("/intel")
public class IntelServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    ArticleDao articleDao = new ArticleDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取文章列表
        ArrayList<Article> articles = articleDao.queryAllArticles();
        request.setAttribute("articles",articles);

//        User user = userDao.queryUserByName(username);

        //获取当前时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String dateHH = format.format(date);
        request.setAttribute("systemDate",dateHH);
        //获取user表的有效用户数
//        Integer userTotal = userDao.queryUserCount();
//        request.setAttribute("user_total",userTotal);

        //都会数据库交互
        request.getRequestDispatcher("/intel.jsp").forward(request,response);
    }
}
