package com.eason.springmvc.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter only cross once, as we requested, and we can put something in request and response.
 *
 * Created by feng yingsheng on 10/3/2017.
 */
@Slf4j
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter {

    public MyFilter() {
        log.info("MyFilter is inited ....");
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter inited..." + filterConfig.getFilterName());
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String a = servletRequest.getParameter("a");
        if(StringUtils.isEmpty(a)) {
            log.error("filter get a is empty");
        }
        else {
            log.info("filter get a=" + a);
        }
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        log.info("filter destoried now...");
    }
}
