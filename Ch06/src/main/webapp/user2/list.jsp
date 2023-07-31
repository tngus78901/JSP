<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터베이스 처리
	List<User2VO> users = new ArrayList<>();
	
	try{
			
			// JNDI 서비스 객체 생성
			Context initCtx  = new InitialContext();
			Context ctx = (Context) initCtx.lookup("javaLcomp/env"); // JNDI 기본 환경이름
			
			// 커넥션 풀에서 커넥셕 가져오기
			DataSource ds = (DataSource) ctx.lookup("jdbc/userdb");
			Connection conn = ds.getConnetion();
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `user2`");
			
			while(rs.next()){
					User2VO vo = new User2VO();
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
		<title>user2::list</title>
	</head>
	<body>
			<h3>User2 목록</h3>
			<a href="/Ch06/1_JDBC.jsp"></a>
			<a href="/Ch06/user2/register.jsp">User2 등록</a>
			
			<table>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>휴대폰</th>
						<th>나이</th>
						<th>관리</th>
					</tr>
					<% for(User2VO vo : users) { %>
					<tr>
						<td><%= vo.getUid() %></td>
						<td><%= vo.getName() %></td>
						<td><%= vo.getHp() %></td>
						<td><%= vo.getAge() %></td>
						<td></td>
						<td>
								<a href="/Ch06/user2/modify.jsp?uid=<%= vo.getUid() %>">수정</a>
								<a href="/Ch06/user2/delete.jsp?uid=<%= vo.getUid() %>">삭제</a>
						</td>
					</tr>
					<% } %>
			
			
			
			
			
			</table>
	</body>
</html>