package com.maksgir.servlets;

import com.maksgir.entity.RequestParams;
import com.maksgir.util.ParamsValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

@WebServlet("/submit")
public class ControllerServlet extends HttpServlet {

    private ParamsValidator paramsValidator = new ParamsValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
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

            String x = req.getParameter("x").trim();
            String y = req.getParameter("y").trim();
            String r = req.getParameter("r").trim();
            String timezone = req.getParameter("timezone").trim();
            if (paramsValidator.validate(x, y, r, timezone, writer)) {
                System.out.println("Параметры валидны");
            } else {
                System.out.println("Параметры не валидны");
            }

//            RequestParams reqValues = new RequestParams(x, y, r, timezone);

            // метод по обработке запроса
        }


    }
}
