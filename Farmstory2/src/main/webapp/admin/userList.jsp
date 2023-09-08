<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<script>
	$(function(){
		
		$('.showPopup').click(function(e){
			e.preventDefault();
			$('#userPopup').show();
		});
		
		$('#userPopup .btnClose').click(function(){
			$('#userPopup').hide();						
		});
				
	});
</script>
<main>
    <aside>
        <h3>주요기능</h3>
        <ul>
            <li><a href="/Farmstory2/admin/productList.do">상품관리</a></li>
            <li><a href="/Farmstory2/admin/orderList.do">주문관리</a></li>
            <li class="on"><a href="/Farmstory2/admin/userList.do">회원관리</a></li>                    
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
                    <th>아이디</th>
                    <th>이름</th>
                    <th>닉네임</th>
                    <th>이메일</th>
                    <th>휴대폰</th>
                </tr>
                 <c:forEach var="user" items="${users}">    
                <tr>
	                <!--  들어가야 하는 정보 -->
	                <td><input type="checkbox" name="" value="checkbox"/></td>
                    <td>${user.uid}</td>
                    <td>${user.name}</td>
                    <td>${user.nick}</td>
                    <td>${user.email}</td>
                    <td>${user.hp}</td>
	            </tr>
	            </c:forEach>
            </table>

           
            
            <p class="paging">
                <a href="#"><</a>
                <a href="#" class="on">[1]</a>
                <a href="#">[2]</a>
                <a href="#">[3]</a>
                <a href="#">[4]</a>
                <a href="#">[5]</a>
                <a href="#">></a>
            </p>
        </article>
    </section>
</main>
<%@ include file="./_footer.jsp" %>