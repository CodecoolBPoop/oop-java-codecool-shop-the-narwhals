package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
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
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        //context.setVariables(params);

        String categoryIdFromUrl = req.getParameter("category");
        String supplierIdFromUrl = req.getParameter("supplier");

        context.setVariable("recipient", "World");
        context.setVariable("categories", productCategoryDataStore.getAll());
        context.setVariable("products", productDataStore.getAll());
        context.setVariable("suppliers", supplierDataStore.getAll());


        if(categoryIdFromUrl != null){
            context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(Integer.parseInt(categoryIdFromUrl))));
            context.setVariable("categories", productCategoryDataStore.find(Integer.parseInt(categoryIdFromUrl)));
        } else if (supplierIdFromUrl != null){
            context.setVariable("products", productDataStore.getBy(supplierDataStore.find(Integer.parseInt(supplierIdFromUrl))));
            context.setVariable("suppliers", supplierDataStore.find(Integer.parseInt(supplierIdFromUrl)));
        }
        else {
            context.setVariable("products", productDataStore.getAll());
        }

        engine.process("product/index.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("recipient", "World");
        context.setVariable("products", productDataStore.getAll());
        context.setVariable("categories", productCategoryDataStore.getAll());
        engine.process("product/index.html", context, resp.getWriter());
    }
}
