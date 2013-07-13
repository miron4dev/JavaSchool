package com.tsystems.demail.Filters;


import com.tsystems.demail.Beans.UserBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SessionFilter implements Filter {

    private ArrayList<String> urlList;

    @Inject
    private UserBean userBean;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getServletPath();

        if (urlList.contains(url) && !userBean.isProfileLoggedIn()){
            response.sendRedirect(request.getContextPath() + "/index.jsf");
        }
        else filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        String urls = config.getInitParameter("not-avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");

        urlList = new ArrayList<String>();

        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());

        }
    }

    @Override
    public void destroy() {
    }

}
