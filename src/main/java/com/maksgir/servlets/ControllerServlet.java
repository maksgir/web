package com.maksgir.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/submit")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clean = (String) req.getParameter("clean");
        int x = Integer.parseInt(req.getParameter("x"));
        int y = Integer.parseInt(req.getParameter("y"));
        double r = Double.parseDouble(req.getParameter("r"));
        int timezone = Integer.parseInt(req.getParameter("timezone"));


        System.out.println("*************************");
        System.out.println("clean " + clean);
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("r: " + r);
        System.out.println("timezone: " + timezone);



    }
}
