<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>4_Class</title>
		<!-- 
			DATE : 24TH JULY.2023
			NAME : JUSITNA
			CONTENT : JSP 스크립트릿 클래스 실습하기
		 -->
	</head>
	<body>
		<h3>4.클래스</h3>
		
		<%
			Account kb = new Account("국민은행","101-12-1001","김유신", 10000 );
			kb.deposit(30000);
			kb.withdraw(5000);
			kb.deposit(out);
			
			Account wr = new Account("우리은행","101-11-1001","김춘추", 20000 );
			kb.deposit(30000);
			kb.withdraw(5000);
			kb.deposit(out);
		
		%>
		
		
	</body>
</html>