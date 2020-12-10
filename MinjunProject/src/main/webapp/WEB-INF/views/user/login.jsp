<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>아이디 입력</p>
<input type = "text" id = "id">

<p>비밀번호 입력</p>
<input type = "password" id = "pw">

<input type = "checkbox" id = "auto-login" name = "autoLogin" >자동로그인

<input type= "button" id = "login_btnn" value = "로그인 ">


<input type= "button" value = "게시판 돌아가기" id = "cancel">

</body>
<script>

$(function(){	
	
	$("#cancel").click(function(){
		

		
		location.href = "/board/list";
				
		
	});
	

	$("#login_btnn").click(function(){
		//id 로 가져온것 
		const id = $("#id").val();
		const pw = $("#pw").val();
		//아이디 말고 name 으로 보는 방법 
	const autoLogin = $("#auto-login").is(":checked");

		const user = {
			
			account : id,
			password : pw,
			autoLogin : autoLogin
			};
		
		
		$.ajax({
			type: "POST",
			url: "/user/login",
			headers: {
				"Content-Type" : "application/json"
			},
			data : JSON.stringify(user),
			dataType : "text",
			success: function(result) { 
			
				if(result === "loginSuccess") {
					alert("로그인 에 성공했습니다!");
					location.href="/board/list";
				} else if (result === "pwFail") {
					alert("로그인 에 실패했습니다!");
				}else if(result === "idFail"){
					alert("아이디 실패했습니다!");
				}
					
			}, 
			error: function() {
			
			}
		});
	});
	
	
	
});


</script>


</html>


