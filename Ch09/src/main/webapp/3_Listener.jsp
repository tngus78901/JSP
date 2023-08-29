<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String success = request.getParameter("success");

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>2_Filter</title>
		<!-- 
			Date : 23rd August 2023
			Name : Justina
			Content : to practice Listener
		
		 	리스너(Listener)
		 	- 웹 애플리케이션 컨테이너를 감시해서 특정 이벤트나 동작에 실행되는 특수 서블릿
		 	- WAS의 시작/종료를 감시하는 ServletContextListener, 세션처리를 감시하는 HttpSessionListener 등		
		 -->
	</head>
	<body>
		<h3>3.리스너</h3>
		
		<h4>세션리스너 실습</h4>
		
		<% if(success == null || !success.equals("200")) { %>
		<form action="/Ch09/hello.do" method="post">
			<input type="text" name="uid"/><br>
			<input type="password" name="pass"/><br>
			<input type="submit" value="로그인"/>		
		</form>
		<% }else{ %>
		<a href="/Ch09/logout.jsp">로그아웃</a>
		<% } %>
	</body>
</html>