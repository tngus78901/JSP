package sub2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterB implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 필터 처리될 로직 수행
		System.out.println("FilterB doFilter()...");  // 각각의 필터배치는 web.xml
		
		// 다음 필터 호출, 필터가 없으면 최종 자원 요청
		chain.doFilter(request, response);
	}
	
	

}