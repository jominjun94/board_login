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
<input type = "text" id = "idChk">
<p>비밀번호 입력</p>
<input type = "password" id = "pw">
<p>이름 입력</p>
<input type = "text" id = "name">


<input type= "button" id = "log_btn" value = "회원가입 ">

</body>
<script>

$(function(){	
	
	$('#id').on('keyup',function(){
		
			const id = $('#id').val();
			$.ajax({
				type: "POST",
				url: "/user/checkId",	
				headers: {
	                "Content-Type": "application/json"
	            },
				dataType: "text",
				data: id,
				success: function(result) {
					if(result === "OK") {
						$("#id").css("background-color", "aqua");
						$("#idChk").html("<b style='font-size:14px; color:green;'>[아이디는 사용 가능!]</b>");						
						
					} else if(result === "no") {
						$("#id").css("background-color", "pink");
						$("#idChk").html("<b style='font-size:14px; color:red;'>[아이디가 중복됨!]</b>");						
					
					}
				},
				error: function() {
					console.log("통신 실패!");
				}
			});
		
		
		
		
	});
	

	$("#log_btn").click(function(e){
		
		const id = $("#id").val();
		const pw = $("#pw").val();
		const name =  $("#name").val();

		const user = {
			
			account : id,
			password : pw,
			name : name
			};
		
		
		$.ajax({
			type: "POST",
			url: "/user/",
			headers: {
				"Content-Type" : "application/json"
			},
			data : JSON.stringify(user),
			dataType : "text",
			success: function(result) { 
			
				if(result === "joinSuccess") {
					alert("회원가입에 성공했습니다!");
					location.href="/board/list";
				} else {
					alert("회원가입에 실패했습니다!");
				}
			}, 
			error: function() {
			
			}
		});
	});
	
	
	
});


</script>


</html>


