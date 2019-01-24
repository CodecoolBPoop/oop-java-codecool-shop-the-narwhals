package com.codecool.shop.controller;


import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.implementation.OrderDaoJDBC;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.model.Order;
import com.codecool.shop.personal.ContactInfo;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/payment"})
public class PaymentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        OrderDao orderDataStore = OrderDaoMem.getInstance();

        context.setVariable("order", ((OrderDaoMem) orderDataStore).findLast());

        engine.process("payment.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OrderDao orderMemDataStore = OrderDaoMem.getInstance();
        OrderDao orderDBDataStore = OrderDaoJDBC.getInstance();
        Order order = ((OrderDaoMem) orderMemDataStore).findLast();
        ContactInfo contactInfo = order.getContactInfo();
        ((OrderDaoJDBC) orderDBDataStore).add(contactInfo);
        orderDBDataStore.add(order);
        response.sendRedirect("/confirmation");
    }
}
