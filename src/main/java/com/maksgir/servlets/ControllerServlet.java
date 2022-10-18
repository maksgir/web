package com.maksgir.servlets;

import com.maksgir.entity.RequestValues;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submit")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("init") != null && Boolean.parseBoolean(req.getParameter("init"))) {
            // метод возвращающий значения таблицы из сессии
        }

        if (req.getParameter("clean") != null && Boolean.parseBoolean(req.getParameter("clean"))) {
            // метод по очистке таблице
        }
        if (req.getParameter("x") != null &&
                req.getParameter("y") != null &&
                req.getParameter("r") != null &&
                req.getParameter("timezone") != null) {
            int x = Integer.parseInt(req.getParameter("x"));
            int y = Integer.parseInt(req.getParameter("y"));
            double r = Double.parseDouble(req.getParameter("r"));
            int timezone = Integer.parseInt(req.getParameter("timezone"));
            RequestValues reqValues = new RequestValues(x, y, r, timezone);

            // метод по обработке запроса
        }



    }
}
