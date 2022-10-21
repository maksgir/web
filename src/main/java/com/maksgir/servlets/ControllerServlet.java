package com.maksgir.servlets;

import com.maksgir.entity.RequestParams;
import com.maksgir.entity.RowBean;
import com.maksgir.util.ParamsValidator;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/submit")
public class ControllerServlet extends HttpServlet {

    private ParamsValidator paramsValidator = new ParamsValidator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();

        createTableIfNeeded(session);
        // прилетел запрос на инициализацию таблицы
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

        String clean_msg = req.getParameter("clean");
        Boolean clean_bool = null;
        if (clean_msg != null) {
            try {
                clean_bool = Boolean.parseBoolean(req.getParameter("clean"));
            } catch (Exception e) {
                resp.sendError(400, "Bad clean param");
                return;
            }
        }


        if (init_bool != null && init_bool) {
            resp.setContentType("application/json");
            initTable(writer, session);
        }
        // прилетел запрос на очистку
        else if (clean_bool != null && clean_bool) {

            clearTable(session);
            writer.write("Таблица успешно очищена");

        }
        // прилетел запрос проверку попадания
        else if (req.getParameter("x") != null &&
                req.getParameter("y") != null &&
                req.getParameter("r") != null &&
                req.getParameter("timezone") != null) {

            req.setAttribute("start", System.currentTimeMillis());
            String x = req.getParameter("x").trim();
            String y = req.getParameter("y").trim();
            String r = req.getParameter("r").trim();
            String timezone = req.getParameter("timezone").trim();
            if (paramsValidator.validate(x, y, r, timezone, writer)) {

                RequestParams requestParams = new RequestParams(Double.parseDouble(x), Double.parseDouble(y),
                        Double.parseDouble(r), Integer.parseInt(timezone));
                req.setAttribute("params", requestParams);
                getServletContext().getRequestDispatcher("/check-area").forward(req, resp);
            } else {
                resp.setStatus(400);
            }

            // метод по обработке запроса
        } else {
            resp.setStatus(400);
            writer.write("Не все параметры заданы");
        }
        writer.close();
    }

    private void createTableIfNeeded(HttpSession session) {
        List<RowBean> table = (List<RowBean>) session.getAttribute("table");
        if (table == null) {
            session.setAttribute("table", new ArrayList<RowBean>());
        }
    }


    private void initTable(PrintWriter writer, HttpSession session) {
        List<RowBean> table = (List<RowBean>) session.getAttribute("table");
        writer.print(new JSONArray(table));
    }

    private void clearTable(HttpSession session) {
        session.setAttribute("table", new ArrayList<RowBean>());
        session.setAttribute("lastMod", LocalDateTime.now());
    }


}
