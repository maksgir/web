package com.maksgir.servlets;


import com.maksgir.entity.RequestParams;
import com.maksgir.util.AreaHitChecker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/check-area")
public class AreaCheckServlet extends HttpServlet {
    private AreaHitChecker hitChecker = new AreaHitChecker();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestParams params = (RequestParams) req.getAttribute("params");

        if (hitChecker.checkHit(params.getX(), params.getY(), params.getR())){
            // метод по созданию ответа
        }
    }
}
