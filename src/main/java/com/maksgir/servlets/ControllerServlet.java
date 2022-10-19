package com.maksgir.servlets;

import com.maksgir.entity.RequestParams;
import com.maksgir.entity.ResponseParams;
import com.maksgir.util.HtmlTableCreator;
import com.maksgir.util.ParamsValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet("/submit")
public class ControllerServlet extends HttpServlet {

    private ParamsValidator paramsValidator = new ParamsValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();

        if (req.getParameter("init") != null && Boolean.parseBoolean(req.getParameter("init"))) {
            initTable(writer, session);
        } else if (req.getParameter("clean") != null && Boolean.parseBoolean(req.getParameter("clean"))) {
            clearTable(session);
            writer.write("Таблица успешно очищена");
        } else if (req.getParameter("x") != null &&
                req.getParameter("y") != null &&
                req.getParameter("r") != null &&
                req.getParameter("timezone") != null) {

            req.setAttribute("start_time", LocalTime.now());
            String x = req.getParameter("x").trim();
            String y = req.getParameter("y").trim();
            String r = req.getParameter("r").trim();
            String timezone = req.getParameter("timezone").trim();
            if (paramsValidator.validate(x, y, r, timezone, writer)) {

                RequestParams reqValues = new RequestParams(Integer.parseInt(x), Integer.parseInt(y),
                        Double.parseDouble(r), Integer.parseInt(timezone));
                req.setAttribute("params", reqValues);
                getServletContext().getRequestDispatcher("/check-area").forward(req, resp);
            } else {
                resp.setStatus(400);
            }

            // метод по обработке запроса
        } else {
            resp.setStatus(400);
            writer.write("Не все параметры заданы");
        }
    }


    private void initTable(PrintWriter writer, HttpSession session) {
        List<ResponseParams> responseBeans = (List<ResponseParams>) session.getAttribute("responseBeans");
        if (responseBeans == null) {
            session.setAttribute("responseBeans", new ArrayList<ResponseParams>());
        } else {
            writer.write(HtmlTableCreator.createTableRows(responseBeans));
        }
    }

    private void clearTable(HttpSession session) {
        List<ResponseParams> responseBeans = (List<ResponseParams>) session.getAttribute("responseBeans");
        if (responseBeans != null) {
            responseBeans.clear();
        }
    }


}
