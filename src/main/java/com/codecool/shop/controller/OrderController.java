package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = {"/cart"})
public class OrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderDao orderDataStore = OrderDaoMem.getInstance();

        ServletContext servletContext = req.getServletContext();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(servletContext);
        WebContext context = new WebContext(req,resp, servletContext);

        context.setVariable("order", ((OrderDaoMem) orderDataStore).findLast()); // TODO: need to handle case of zero order

        engine.process("cart.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("got POST req");
    }
}
