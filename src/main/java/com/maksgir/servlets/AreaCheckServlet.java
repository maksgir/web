package com.maksgir.servlets;


import com.maksgir.entity.RequestParams;
import com.maksgir.entity.RowBean;
import com.maksgir.util.AreaHitChecker;
import org.json.JSONArray;
import org.json.JSONObject;

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
        long start = (long) req.getAttribute("start");

        String answer = hitChecker.checkHit(requestParams.getX(), requestParams.getY(), requestParams.getR()) ?
                "Попал" : "Не попал";

        RowBean row = new RowBean(requestParams.getX(), requestParams.getY(),
                requestParams.getR(), answer, start, requestParams.getTimezone());

        HttpSession session = req.getSession();

        List<RowBean> table = (List<RowBean>) session.getAttribute("table");
        table.add(row);

        resp.setContentType("application/json");
        writer.print(new JSONObject(row));
        writer.close();

    }
}
