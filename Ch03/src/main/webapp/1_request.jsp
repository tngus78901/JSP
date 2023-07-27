<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>1_request</title>
		<!-- Date : 25th.July.2023
			 Name : Justina
			 Content : JSP request 내장객체 실습하기	
			 
			 request 내장객체
			 - 클라이언트 요청 정보를 갖는 객체
			 - 클라이언트 전송데이터를 수신하는 기능 제공(getParameter)
			 
			 GET 방식
			 - 기본 데이터 전송 방식
			 - 전송 데이터가 주소에 노출

			 POST 방식 
			 - 전송 데이터가 요청 객체(request) body에 삽입되어 전송되는 방식
			 - 전송 데이터 노출 안됨			 
			 
			 
		 -->
	</head>
	<body>
		<h3>1.request 내장객체</h3>
		
		<h4>사용자 입력</h4>
		<form action="./proc/userProc.jsp" method="get"> <!--  method속성없으면 get방식이 default 근데 비번나옴 그래서 host방식으로 전송해야-->
			<input type="text" name="uid" placeholder="아이디 입력"/><br>
			<input type="text" name="name" placeholder="이름 입력"/><br>
			<input type="text" name="age" placeholder="나이입력"/><br>
			<input type="submit" name="전송하기"/>
		
		</form>  <!--  이 form을 userProc에 제출 -->
		
		<h4>회원가입</h4>
		<form action="./proc/registerProc.jsp" method="post">
			<table border="1">
				<tr>
					<td></td>
					<td><input type="text" name="uid" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="password" name="pass" placeholder="비밀번호 입력"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="text" name="name" placeholder="이름입력"/></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date" name="birth" placeholder="생년월일 선택"/></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<label><input type="radio" name="gender" value="1"/>남</label>
						<label><input type="radio" name="gender" value="2"/>여</label>
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<select name="addr">
							<option>서울</option>
							<option>대전</option>
							<option>대구</option>
							<option>부산</option>
							<option>광주</option>
							
						</select>		
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<label><input type="checkbox" name="hobby" value="등산">등산하기</label>
						<label><input type="checkbox" name="hobby" value="독서">독서하기</label>
						<label><input type="checkbox" name="hobby" value="영화">영화보기</label>
						<label><input type="checkbox" name="hobby" value="운동">운동하기</label>
						<label><input type="checkbox" name="hobby" value="게임">게임하기</label>
						
					</td>		
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="회원가입"/>
					</td>	
				</tr>
				</table>
		</form>	
		
	</body>
</html>