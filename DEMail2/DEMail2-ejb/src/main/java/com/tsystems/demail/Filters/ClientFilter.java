package com.tsystems.demail.Filters;

import com.tsystems.demail.Beans.UserBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientFilter implements Filter {

    @Inject
    private UserBean userBean;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getServletPath();

        if (url.equals("/client.jsf") && !userBean.isMailLoggedIn() || url.equals("/registration.jsf") && userBean.isProfileLoggedIn()){
            response.sendRedirect(request.getContextPath() + "/login.jsf");
        }
        else filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
