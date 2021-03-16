package com.stx.xc.BBS.serviet.filter;

import com.stx.xc.BBS.entity.User;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({
        "/article/delete",
        "/article/modify",
        "/article/show",
        "/article/create",
        "/add/comment",
        "/comment/delete",
        "/delete/user",
        "/like/article",
        "/intel/private",
        "/update/comment",
        "/change/information",

})
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("login_user");
        if (loginUser != null) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
