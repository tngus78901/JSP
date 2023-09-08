<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<main>
    <aside>
        <h3>주요기능</h3>
        <ul>
            <li class="on"><a href="/Farmstory2/admin/productList.do">상품관리</a></li>
            <li><a href="/Farmstory2/admin/orderList.do">주문관리</a></li>
            <li><a href="/Farmstory2/admin/userList.do">회원관리</a></li>                    
        </ul>
    </aside>
    <section id="productList">
        <nav>
            <h3>상품목록</h3>
        </nav>

        <article>

            <table border="0">
                <tr>
                    <th><input type="checkbox" name="all"/></th>
                    <th>사진</th>
                    <th>상품번호</th>
                    <th>상품명</th>
                    <th>구분</th>
                    <th>가격</th>
                    <th>재고</th>
                    <th>등록일</th>
                </tr>
                 <c:forEach var="product" items="${products}">                    
				            <tr>
				                <!--  들어가야 하는 정보 -->
				                <td><input type="checkbox" name="" value="${product.pNo}"/></td>
			                    <td><img src="/Farmstory2/thumb/${product.thumb1}" class="thumb" alt="샘플1"></td>
			                    <td>${product.pNo}</td>
			                    <td>${product.pName}</td>
			                    <td>${product.type}</td>
			                    <td>${product.price}</td>
			                    <td>${product.stock}</td>
			                    <td>${product.rdate}</td>
				            </tr>
	            </c:forEach>
                </tr>
            </table>

            <p>
                <a href="#" class="productDelete">선택삭제</a>
                <a href="./productRegister.do" class="productRegister">상품등록</a>
            </p>
		    <!-- 페이지 네비게이션 -->
	        <div class="paging">
	        	<c:if test="${pageGroupStart > 1}">
	            	<a href="${ctxPath}/admin/productList.do?&pg=${pageGroupStart - 1}" class="prev">이전</a>
	            </c:if>
	            <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
	            	<a href="${ctxPath}/admin/productList.do?pg=${i}" class="num ${currentPage == i?'current':'off'}">${i}</a>
	            </c:forEach>
	            <c:if test="${pageGroupEnd < lastPageNum}">
	            	<a href="${ctxPath}/admin/productList.do?pg=${pageGroupEnd + 1}" class="next">다음</a>
	            </c:if>
	        </div>
				
        </article>
    </section>
</main>
<%@ include file="./_footer.jsp" %>