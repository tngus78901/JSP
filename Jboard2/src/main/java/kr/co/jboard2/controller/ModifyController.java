package kr.co.jboard2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modify.do")
public class ModifyController extends HttpServlet{
	
	
	private static final long serialVersionUID = -8989721235114878879L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		 	RequestDispatcher dispatcher = req.getRequestDispatcher("");
		 	dispatcher.forward(req, resp);
	}

}
