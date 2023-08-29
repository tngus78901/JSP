package kr.co.jboard2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user/findId.do")
public class FindIdController extends HttpServlet {


	private static final long serialVersionUID = -3295874385145085192L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
			RequestDispatcher dispatcher = req.getRequestDispatcher("/user/findId.jsp");
			dispatcher.forward(req, resp);
		
	}
}
