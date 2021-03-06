package org.itstep.prokopchik.cricova.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * фильтр, перенаправляющий все прямые обращения к страницам на стартовую
 * страницу
 */

@WebFilter(urlPatterns = {"/jsp/*"},
        initParams = {@WebInitParam(name = "INDEX_PATH", value = "/index.jsp")})

public class PageRedirectSecurityFilter implements Filter {

    private String indexPath;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        indexPath = fConfig.getInitParameter("INDEX_PATH");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // переход на заданную страницу
        httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
