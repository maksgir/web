package com.maksgir.servlets;


import com.maksgir.entity.RequestParams;
import com.maksgir.entity.ResponseParams;
import com.maksgir.util.AreaHitChecker;
import com.maksgir.util.HtmlTableCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.List;

@WebServlet("/check-area")
public class AreaCheckServlet extends HttpServlet {
    private AreaHitChecker hitChecker = new AreaHitChecker();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        RequestParams requestParams = (RequestParams) req.getAttribute("params");
        LocalTime start = (LocalTime) req.getAttribute("start_time");

        String answer = hitChecker.checkHit(requestParams.getX(), requestParams.getY(), requestParams.getR()) ?
                "Попал" : "Не попал";

        ResponseParams responseParams = new ResponseParams(requestParams.getX(), requestParams.getY(),
                requestParams.getR(), answer, start);

        HttpSession session = req.getSession();

        List<ResponseParams> responseBeans = (List<ResponseParams>) session.getAttribute("responseBeans");
        responseBeans.add(responseParams);

        writer.write(HtmlTableCreator.createTableRow(responseParams));

    }
}
