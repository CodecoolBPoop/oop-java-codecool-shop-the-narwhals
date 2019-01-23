package com.codecool.shop.controller;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.Order;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ProductDao productDataStore = ProductDaoMem.getInstance();

//        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoJDBC.getInstance();
//        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoJDBC.getInstance();
        ProductDao productDataStore = ProductDaoJDBC.getInstance();
        OrderDao orderDataStore = OrderDaoMem.getInstance();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariables(params);

        int categoryIdFromUrl = req.getParameter("category") == null ? 0 : Integer.parseInt(req.getParameter("category"));
        int supplierIdFromUrl = req.getParameter("supplier") == null ? 0 : Integer.parseInt(req.getParameter("supplier"));

        context.setVariable("recipient", "World");
        context.setVariable("categories", productCategoryDataStore.getAll());
        context.setVariable("suppliers", supplierDataStore.getAll());
//        context.setVariable("products", productDataStore.getAll());



        try {
            Order currentOrder = ((OrderDaoMem) orderDataStore).findLast();
            context.setVariable("numberOfProductsInCart", currentOrder.getTotalNumberOfOrderedProducts());
        }
        catch (IndexOutOfBoundsException e) {
            context.setVariable("numberOfProductsInCart", 0);
        }

        if (categoryIdFromUrl != 0 && supplierIdFromUrl != 0) {
            context.setVariable("products", productDataStore.getByComplex(categoryIdFromUrl, supplierIdFromUrl));
            context.setVariable("selectedCategory", productCategoryDataStore.find(categoryIdFromUrl));
            context.setVariable("selectedSupplier", supplierDataStore.find(supplierIdFromUrl));
        } else if (categoryIdFromUrl != 0) {
            context.setVariable("products",
                    productDataStore.getBy(productCategoryDataStore.find(categoryIdFromUrl)));
            context.setVariable("selectedCategory", productCategoryDataStore.find(categoryIdFromUrl));
        } else if (supplierIdFromUrl != 0) {
            context.setVariable("products",
                    productDataStore.getBy(supplierDataStore.find(supplierIdFromUrl)));
            context.setVariable("selectedSupplier", supplierDataStore.find(supplierIdFromUrl));
        } else {
            context.setVariable("products", productDataStore.getAll());
        }

        engine.process("product/index.html", context, resp.getWriter());
    }
}
