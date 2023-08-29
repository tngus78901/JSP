<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<main id="board">
    <section class="modify">
           <form action="#">
                        <table border="0">
                        	<caption>글쓰기</caption>
                            <tr>
                                <td>제목</td>
                                <td><input type="text" name="title" placeholder="제목을 입력하세요."/></td>
                            </tr>
                            <tr>
                                <td>내용</td>
                                <td>
                                    <textarea name="content"></textarea>                                
                                </td>
                            </tr>
                            <tr>
                                <td>파일</td>
                                <td><input type="file" name="file"/></td>
                            </tr>
                        </table>
                        
                        
                        <div>
                            <a href="./list.html" class="btn btnCancel">취소</a>
                            <input type="submit"  value="작성완료" class="btn btnComplete">
                        </div>
                    </form>
                
            </section>
        </main>
 <%@ include file="./_footer.jsp" %>