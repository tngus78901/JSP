package kr.co.farmstory2.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductListController extends HttpServlet {
	
	private static final long serialVersionUID = 674836839312349781L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/productList");
		dispatcher.forward(req, resp);
	}

}
