<%@page import="java.security.ProtectionDomain"%>
<%@page import="kr.farmstory1.dto.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="kr.farmstory1.dao.ProductDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String type = request.getParameter("type");
	String pg = request.getParameter("pg");

	if(type == null) {
		type = "0";		
	}
	
	ProductDAO dao = new ProductDAO();
	
	// 페이지 그룹 계산
	pageGroupCurrent = (int) Math.ceil(currentPage / 10.0);
	pageGroupStart = (pageGroupCurrent - 1);
	
	List<ProductDTO> products = dao.selectProducts(type, start); //Parameter로 받은 타입



%>

 <div id="sub">
            <div><img src="../images/sub_top_tit2.png" alt="MARKET"></div>
            <section class="market">
                <aside>
                    <img src="../images/sub_aside_cate2_tit.png" alt="장보기"/>

                    <ul class="lnb">
                        <li class="on"><a href="./market.html">장보기</a></li>
                    </ul>
                </aside>
                <article class="list">
                    <nav>
                        <img src="../images/sub_nav_tit_cate2_tit1.png" alt="장보기"/>
                        <p>
                            HOME > 장보기 > <em>장보기</em>
                        </p>
                    </nav>

                    <!-- 내용 시작 -->
                    <p class="sort">
                        <a href="./list.jsp?type=0" class="<%= type.equals("0") ? "on":"" %>">전체<%= type.equals("0"?"("+total")":"" %> |</a>
                        <a href="./list.jsp?type=1" class="<%= type.equals("1") ? "on":"" %>">과일<%= type.equals("1"?"("+total")":"" %> |</a>
                        <a href="./list.jsp?type=2" class="<%= type.equals("2") ? "on":"" %>">야채<%= type.equals("2"?"("+total")":"" %> |</a>
                        <a href="./list.jsp?type=3" class="<%= type.equals("3") ? "on":"" %>">곡류<%= type.equals("3"?"("+total")":"" %></a>
                    </p>
                    <table border="0">
                    	<% for(ProductDTO product : products) { %>
                        <tr>
                            <td>
                                <a href="./view.html"><img src="/Farmstory1/thumb/<%= product.getThumb1() %>"  class="thumb" alt="사과 500g"></a>
                            </td>
                            <td>과일</td>
                            <%
                            	switch(product.getType()) {
                            	case 1: out.print("과일"); break;
                            	case 2: out.print("야채"); break;
                            	case 3: out.print("곡물"); break;
                            	
                            	}
                            
                            %>
                            
                            <td><a href="#">사과 500g</a></td>
                            <td><strong>4,000</strong>원</td>
                        </tr>
                       <% } %>
                    </table>

                    <div class="paging">
                        <a href="#"><</a>
                        <a href="#">[1]</a>
                        <a href="#">[2]</a>
                        <a href="#">[3]</a>
                        <a href="#">[4]</a>
                        <a href="#">[5]</a>
                        <a href="#">></a>
                    </div>

                    <!-- 내용 끝 -->

                </article>
            </section>

        </div>
        
  <%@ include file="../_footer.jsp" %>