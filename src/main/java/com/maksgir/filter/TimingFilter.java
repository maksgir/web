package com.maksgir.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebFilter("/*")
public class TimingFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;


        String init_msg = req.getParameter("init");
        Boolean init_bool = null;
        if (init_msg != null) {
            try {
                init_bool = Boolean.parseBoolean(req.getParameter("init"));
            } catch (Exception e) {
                resp.sendError(400, "Bad init param");
                return;
            }
        }

        if (init_bool != null && init_bool) {
            String header = req.getHeader("If-Modified-Since");
            if (header != null) {
                // parse date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz");
                LocalDateTime timeFromReq = LocalDateTime.parse(header, formatter);
                LocalDateTime lastModified = (LocalDateTime) req.getSession().getAttribute("lastMod");

                if (lastModified != null && lastModified.isBefore(timeFromReq)) {
                    resp.setStatus(304);
                    return;
                }


            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
