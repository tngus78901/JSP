package kr.co.farmstory2.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dto.UserDTO;
import kr.co.farmstory2.service.ArticleService;
import kr.co.farmstory2.service.UserService;



@WebServlet("/admin/userList.do")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = -7860446782600384596L;
	
	private String ctxPath;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService uService = UserService.INSTANCE;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 컨텍스트 경로(/Farmstory2) 구하기(최초 1번, 모든 컨트롤러에 정의)
		ctxPath = config.getServletContext().getContextPath();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			String pg = req.getParameter("pg");
			
			
			// 페이지 관련 변수 선언
			int start = 0;
			int currentPage = 1;
			int total = 0;
			int lastPageNum = 0;
			int pageGroupCurrent = 1;
			int pageGroupStart = 1;
			int pageGroupEnd = 0;
			int pageStartNum = 0;
			
			// 현재 페이지 계산
			if(pg != null) {
					currentPage = Integer.parseInt(pg);
			}
			
			// Limit 시작값 계산
			start = (currentPage -1 ) * 10;
			
			// 페이지 번호 계산
			if(total % 10 == 0) {
					lastPageNum = (total / 10);
			}else {
					lastPageNum = (total / 10) + 1;
			}
			
			// 페이지 그룹 계산
			pageGroupCurrent = (int) Math.ceil(currentPage / 10.0);
			pageGroupStart = (pageGroupCurrent - 1) * 10 +1;
			pageGroupEnd = pageGroupCurrent * 10;
			
			if(pageGroupEnd > lastPageNum) {
					pageGroupEnd = lastPageNum;
			}
			
			List<UserDTO> users = uService.selectUsers();
			
			req.setAttribute("users", users);
			
			logger.debug("users :" + users);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/userList.jsp");
			dispatcher.forward(req, resp);	
	}
	

}