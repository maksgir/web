package com.maksgir.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@WebFilter("/*")
public class HeaderCountingFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        Map<String, Integer> headerMap = new ConcurrentHashMap<>();
        context = filterConfig.getServletContext();
        context.setAttribute("headerMap", headerMap);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Map<String, Integer> headerMap = (ConcurrentHashMap<String, Integer>) context.getAttribute("headerMap");

        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();

            if (headerMap.containsKey(header)) {
                headerMap.put(header, headerMap.get(header) + 1);
            } else {
                headerMap.put(header, 1);
            }
        }

        System.out.println(headerMap);

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
