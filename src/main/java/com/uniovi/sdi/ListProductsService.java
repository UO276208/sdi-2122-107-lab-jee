package com.uniovi.sdi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "ListProductsService", value = "/Products")
public class ListProductsService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        ProductsService productsService = new ProductsService();

        List<Product> products = productsService.getProducts();

        request.getSession().setAttribute("products", products);

        // Retornar la vista con parámetro "storeProducts"
        request.setAttribute("storeProducts", products);
        getServletContext().getRequestDispatcher("/products-view.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
