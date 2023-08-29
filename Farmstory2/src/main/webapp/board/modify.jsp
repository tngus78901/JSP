<%@page import="kr.farmstory1.dto.ArticleDTO"%>
<%@page import="kr.farmstory1.dao.ArticleDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String group = request.getParameter("group");
	String cate = request.getParameter("group");
	String no = request.getParameter("group");

	ArticleDAO dao = new ArticleDAO();
	ArticleDTO dto = dao.selectArticle(no);
	
	pageContext.include("./_aside"+group+".jsp");
	
%>
<section class="modify">
		<h3>글수정</h3>
		<article>
			<form action="/Farmstory1/board/proc/modifyproc.jsp" method="post">
				<input type="hidden" name="no" value="<%= dto.getNo() %>">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" placeholder="제목을 입력하세요."></td>	
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td>첨부</td>
				<td><input type="file" name="file"></td>		
			</tr>
		</table>
		<div>
			<a href="#" class="btnCancel">취소</a>
			<input type="submit" class="btnWrite" value="수정완료">
		</div>
		</form>
		</article>
	</section>
<!-- 내용 끝 -->

		</article>
	</section>
</div>
<%@ include file="../_footer.jsp" %>

