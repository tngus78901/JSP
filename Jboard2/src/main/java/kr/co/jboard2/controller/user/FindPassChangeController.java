package kr.co.jboard2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.jboard2.service.UserService;

@WebServlet("/user/findPassChange.do")
public class FindPassChangeController extends HttpServlet {
		private static final long serialVersionUID = -5829551568076311851L;
	
		private Logger logger = LoggerFactory.getLogger(this.getClass());
		private UserService service = UserService.getInstance();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		HttpSession session	= req.getSession();
		String uid = (String) session.getAttribute("uid");	
			
			if(uid == null) {
				resp.sendRedirect("/Jboard/user/findPass.do");
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/user/findPassChange.jsp");
				dispatcher.forward(req, resp);
			}
		}
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String uid   = req.getParameter("uid");
			String pass  = req.getParameter("pass1");
			
			service.updateUserPass(uid, pass);
			
			resp.sendRedirect("/Jboard2/user/login.do?success=300");
	}

}
