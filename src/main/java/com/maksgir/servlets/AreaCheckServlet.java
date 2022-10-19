package com.maksgir.servlets;


import com.maksgir.entity.RequestParams;
import com.maksgir.entity.ResponseParams;
import com.maksgir.util.AreaHitChecker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalTime;

@WebServlet("/check-area")
public class AreaCheckServlet extends HttpServlet {
    private AreaHitChecker hitChecker = new AreaHitChecker();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestParams requestParams = (RequestParams) req.getAttribute("params");
        LocalTime start = (LocalTime) req.getAttribute("start_time");

        String answer = hitChecker.checkHit(requestParams.getX(), requestParams.getY(), requestParams.getR()) ?
                "Попал" : "Не попал";

        ResponseParams responseParams = new ResponseParams(requestParams.getX(), requestParams.getY(),
                requestParams.getR(), answer, start);

        System.out.println(responseParams);

    }
}
