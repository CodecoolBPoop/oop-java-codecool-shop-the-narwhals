package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.OrderDaoJDBC;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.model.Order;
import com.codecool.shop.personal.Address;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.WebConnection;
import java.io.IOException;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        engine.process("checkout.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        String billingAddress = req.getParameter("billingAddress");
        String billingCity = req.getParameter("billingCity");
        String billingCountry = req.getParameter("billingCountry");
        String billingZip = req.getParameter("billingZip");
        String shippingAddress = req.getParameter("shippingAddress");
        String shippingCity = req.getParameter("shippingCity");
        String shippingCountry = req.getParameter("shippingCountry");
        String shippingZip = req.getParameter("shippingZip");

        Address billingAddressObj = new Address(billingAddress, billingCity, billingCountry, billingZip);
        Address shippingAddressObj = new Address(shippingAddress, shippingCity, shippingCountry, shippingZip);

        OrderDaoJDBC orderDataStore = OrderDaoJDBC.getInstance();
        Order order = orderDataStore.findLast();

        order.addContactInfo(name, email, phoneNumber, billingAddressObj, shippingAddressObj);

        resp.sendRedirect("/payment");
    }
}
