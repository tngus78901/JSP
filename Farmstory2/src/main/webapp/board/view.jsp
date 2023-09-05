<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../_header.jsp" %>
<script>
/*
 5th September 2023
 Jsutina
 commnet insert.fix.delete AJAX and Dynamic processing 동적처리
 */
 
window.onload = function(){
	
		const formComment = document.getElemntById('formComment');
		const commentList = document.getElementsByClassName('commentList')[0];
		
		// 댓글 입력(최신 Javascript(ES6) 문법 적용)
		formComment.onsubmit = async (e) => {
			e.preventDefault();
			
			// 개별 데이터 취합
			const parent = formComment.parent.value;
			const writer = formComment.writer.value;
			const content = formComment.content.value;
			
			// 전송 데이터 생성(폼데이터)
			const paramsData = new URLSearchParams({
					'parent' : parent,
					'writer' : writer,
					'content': content
			});
			
			// 데이터 서버 전송
			const response = await fetch('/Farmstory2/board/comment.do',{
					method : 'POST',
					body : paramsData
				
			});
			
			// 서버 응답 데이터 수신
			const data = await response.json();
			console.log('data : ' + JSON.stringify(data));
			
			if(data != null) {
					// 댓글목록 동적 처리
					let article = "<article>";
						article += "<span class='nick'>"+data.nick+"</span>";
						  article += "<span class='data'>"+data.rdate+"</span>";
						  article += "<textarea readonly class='content'>"+data.content+"</textarea>";
						  article += "<div>";
						  article += "<a href='#' class='remove'>삭제</a>";
						  article += "<a href='#' class='modify'>수정</a>";
						  article += "</div>";
						  article += "</article>";
						  
					commentList.insertAdjacentHTML('beforeend', aritcle);
					alert('댓글이 등록 되었습니다.');				
			
			}else{
					alert('댓글 등록이 실패 했습니다.');
			}
		};// 댓글 입력 끝

}; 
</script>
<jsp:include page="./_aside${group}.jsp"/>
		<section class="view">
			<h3>글보기</h3>
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${article.title}" readonly/></td>
				</tr>
				<c:if test="${article.file} > 0">
					<tr>
						<td>첨부파일</td>
						<td>
								<a href="${ctxPath}/board/fileDownload.do?fno=${article.fileDto.fno}">${article.fileDto.ofile}</a>&nbsp;	
							<span>${article.fileDto.download}</span>회 다운로드
						</td>
					</tr>				
				</c:if>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="content" readonly>${article.content}</textarea>
					</td>
				</tr>
			</table>
			<div>
				<a href="${ctxPath}/board/delete.do?group=${group}&cate=${cate}" class="btnDelete">삭제</a>
				<a href="${ctxPath}/board/modify.do?gorup=${group}&cate=${cate}" class="btnModify">수정</a>
				<a href="${ctxPath}/board/list.do?group=${group}$cate=${cate}" class="btnList">목록</a>
			</div>
			<!--  댓글리스트 -->	
			<section>
				<h3>댓글목록</h3>
			<c:forEach var="comment" items="${comments}">
				<article>
					<!-- style.css 829라인 margin-right: 10px 추가 -->
					<span class="nick">${comment.nick}</span>
					<span class="date">${comment.rdate}</span>
					<textarea readonly class="content">${comment.content}</textarea>
					<div>
						<a href="#" class="remove" data-no="${comment.no}">삭제</a>
						<a href="#" class="modify">수정</a>
					</div>
				</article>
					</c:forEach>
					<c:if test="${empty comments}">
				<p class="empty">등록된 댓글이 없습니다.</p>
					</c:if>	
			</section>		
		
			<!--  댓글입력폼 -->
			<section class="commentForm">
				<h3>댓글쓰기</h3>
				<form id="formComment" action="#" method="post" enctype="multipart/form-data">
				<input type="hidden" name="parent" value="${no}"/>
				<input type="hidden" name="writer" value="${sessUser.uid}"/>
				<input type="hidden" name="nick"   value="${sessUser.nick}"/>
 					<textarea name="content"></textarea>
					<div>
						<a href="#" class="btnCancel">취소</a>
						<input type="submit" id="btnComment"  class="btnWrite" value="작성완료"/>
					</div>				
				</form>
			</section>
			</section>
			</article>
		</section>	
</div>			
<%@ include file="../_footer.jsp" %>