package com.maksgir.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        response.setCharacterEncoding("utf-8");


        // Разрешить request продвигаться дальше. (Перейти данный Filter).
        chain.doFilter(request, response);


    }
}
