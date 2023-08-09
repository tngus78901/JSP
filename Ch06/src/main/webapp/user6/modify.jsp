<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>users6::modify</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
		
		<script>
			$(function(){
				
				// 수정 데이터 요청하기
				$.get("./user.jsp?uid=<%=uid%>".function(data){
						console.log(data);
						
						$('input[name=uid]').val(data.uid);
						$('input[name=name]').val(data.name);
						$('input[name=hp]').val(data.hp);
						$('input[name=age]').val(data.age);
				});
				
				// 수정 데이터 전송하기
				$('input[type=submit]').click(function(e){
					e.preventDefault();
					
					// 수정 데이터 가져오기
					const uid  = $('input[name=uid]').val();
					const name = $('input[name=name]').val();
					const hp   = $('input[name=hp]').val();
					const age  = $('input[name=age]').val();
					
					// JSON 생성
					const jsonData = {
							"uid": uid,
							"name": name ,
							"hp": hp,
							"age": age 
					};
					
					console.log(jsonData);
					
					$.post('./modifyProc.jsp',jsonData, function(data){
						
						if(data.result >= 1){
								alert('데이터가 수정 되었습니다.');
								location.href = './list.jsp';
						}else {
								alert('데이터 수정이 실패했습니다.');
						}
						
					});
				});
				
				
			});
		
			
		</script>
	</head>
	<body>
			<>
		
	</body>
</html>