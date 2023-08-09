<%@page import="com.google.gson.Gson"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.apache.tomcat.jdbc.pool.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.User2VO"%>
<%@page import="java.util.List"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	// 데이터베이스 처리
	List<User2VO> users = new ArrayList<>();
	
	try{
			// JNDI 서비스 객체 생성
			Context initCtx = new InitialContext();
			Context ctx = (Context) initCtx.lookup("java:comp/env"); // JNDI 기본 환경이름
			
			// 커넥션 풀에서 커넥션 가져오기
			DataSource ds = (DataSource) ctx.lookup("jdbc/useddb");
			Connection conn = ds.getConnection();
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `user6`");
			
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
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(users);
		
		out.print(jsonData);
%>