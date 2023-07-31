<%@page import="java.sql.Statement"%>
<%@page import="vo.User1VO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터베이스 처리
	String host = "jdbc:mysql://127.0.0.1:3306/userdb";
	String user = "root";
	String pass = "1234";
	
	List<User1VO> users = new ArrayList<>();
	
	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(host, user, pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `user1`");
			
			while(rs.next()){
					User1VO vo = new User1VO();
					vo.setUid(rs.getString(1));
					vo.setName(rs.getString(2));
					vo.setHp(rs.getString(3));
					vo.setAge(rs.getInt(4));
					
					users.add(vo);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			
	}catch(Exception e){
		e.printStackTrace();
	}	


%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::list</title>
	</head>
	<body>
			<h3>User1 목록</h3>
			<a href = "/Ch06/1_JDBC.jsp">처음으로</a>
			<a href = "/Ch06/user1/register.jsp">User1 등록</a>
			
			
			<table>
				<tr>
						<th></th>				
						<th></th>				
						<th></th>				
						<th></th>				
						<th></th>				
				</tr>
				<% for(User1VO vo : users) { %>
				<tr>
					<td><%= vo.getUid() %></td>
					<td><%= vo.getName() %></td>
					<td><%= vo.getHp() %></td>
					<td><%= vo.getAge() %></td>
					<td>
							<a href="/Ch06/user1/modify.jsp?uid=<%= vo.getUid() %>">수정</a>					
							<a href="/Ch06/user1/delete.jsp?uid=<%= vo.getUid() %>">삭제</a>					
							<a <%= %>></a>					
					</td>
				
				
				
				</tr>			
				<% } %>
			
			
			</table>>
	</body>
</html>