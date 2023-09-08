package kr.co.farmstory2.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.service.ProductService;
import kr.co.farmstory2.dto.ProductDTO;

@WebServlet("/admin/productList.do")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 674836839312349781L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductService service = ProductService.INSTANCE;

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
		
		// 전체 상품 갯수
		total = service.selectCountProductsTotal();
		
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
		
		List<ProductDTO> products = service.selectProducts(start);

		logger.debug("currentPage : " +currentPage);
		logger.debug("products : " +products.size());
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum+1);
			
		req.setAttribute("products", products);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("productList.jsp");
		dispatcher.forward(req, resp);
	}
}
