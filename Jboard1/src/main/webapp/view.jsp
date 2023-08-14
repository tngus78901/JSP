<%@page import="java.util.List"%>
<%@page import="kr.co.jboard1.dto.ArticleDTO"%>
<%@page import="kr.co.jboard1.dao.ArticleDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	
	ArticleDAO dao = new ArticleDAO();
	
	// 원글조회
	ArticleDTO dto = dao.selectArticle(no);
	
	// 댓글조회
	List<ArticleDTO> comments = dao.selectComments(no);

%>
<script>
	$(function(){
		
		// 댓글 내용 전역 변수
		
	});










	$(function(){
		// 댓글 수정
		$('.mod').click(function(e){
			e.preventDefault();
			
			const txt = $(this).text();
			
			if(txt == '수정'){
				$(this).parent().prev().addClass('modi');
				$(this).parent().prev().attr('readonly', false);
				$(this).parent().prev().focus();
				$(this).text('수정완료');
				$(this).prev().show();
			}else{
				// 수정완료 클릭	
				
				if(confirm('정말 수정하시겠습니까?')){
					// 수정 데이터 전송
					$(this).closest('form').submit();
				}
				
				// 수정모드 해체
				$(this).parent().prev().removeClass().
				$(this).parent().attr('readonly', true);
				$(this).hide();
				$(this).next().text('수정');
				
			}
		
	});
		
		// 댓글 수정 취소
		$('.can').click(function(e){
			e.preventDefault();
			
			$(this).parent().prev()
			
		});
		
		
		
		
		// 댓글 삭제
		
		$('.del').click(function(){
			
			const result = confirm('정말 삭제 하시겠습니까?');
			
			if(result) {
					return true;
			}else {
					return false;
			}
			
			
		});
		
		// 댓글쓰기 취소
		// Javascript 방식
		const commentContent = document.querySelector('form >  textarea[name=content]');
		const btnCancel = document.querySelctor('.btnCanel');
		btnCancel.onclick = function(e){
					e.preventDefault();
					commentContent.value = '';
		}
		
		// jQuery 방식
		$('.btnCancel').click(function(e){
				e.prevetnDefault();
				$('form > textarea[name=content]').val('');
		});
		
		
		// 원글 삭제
		const btnDelete = document.getElementsByClassName('btnDelete')[0];
		
		
		
		
		}
		


</script>
<main>
	<section>
		<h3>글보기</h3>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="<%= dto.getTitle() %>" readonly></td>
			</tr>
			<% if(dto.getFile() > 0) { %>
			<tr>
				<td>첨부파일</td>
				<td>
					<a href="#">2020년 상반기 매출자료.xls</a>
					<span>7회 다운로드</span>
				</td>
			</tr>
			<% } %>	
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" readonly><%= dto.getContent() %></textarea>
				</td>
			</tr>	
		</table>
		<div>
			<a href="#" class="btnDelete">삭제</a>
			<a href="#" class="btnModify">수정</a>
			<a href="/Jboard1/list.jsp" class="btnList">목록</a>
		</div>
	
		<!-- 댓글리스트 -->
		<section class="commentList">
			<h3>댓글목록</h3>
			<% for(ArticleDTO comment : comments) { %>
			<article class="comment">
				<span>
					<span><%= comment.getNick() %></span>
					<span><%= comment.getRdate() %></span>  <!-- fullRdate() -->
				</span>
				<textarea name="comment" readonly><%= comment.getContent() %></textarea>
				
				<% if(sessUser.getUid().equals(comment.getWriter())) { %>
				<div>
					<a href="/Jboard1/proc/commentDelete.jsp?no=<%= comment.getNo() %>" class="del">삭제</a>
					<a href="#" class="mod">수정</a>
				</div>
				<% } %>
							
			</article>
			<% } %>
			
			<% if(comments.isEmpty()) { %>  <!-- comments.size() == 0 도 가늫  -->
			<p class="empty">
				등록된 댓글이 없습니다.
			</p>
			<% } %>	
		</section>
	
		<!--댓글입력폼 -->
		<section class="commentForm">
			<h3>댓글쓰기</h3>
			<form action="/Jboard1/proc/commentProc.jsp" method="post">
				<input type="hidden" name="parent" value="<%= no %>"/>
				<input type="hidden" name="writer" value="<%= sessUser.getUid() %>"/>     <!-- 댓글쓰는 건 로그인한 사람 로그인:session -->
				<textarea name="content"></textarea>
				<div>
					<a href="#" class="btnCancel">취소</a>
					<input type="submit" class="btnWrite" value="작성완료">
				</div>
			</form>
		</section>
	</section>
</main>
<%@ include file="./_footer.jsp %>