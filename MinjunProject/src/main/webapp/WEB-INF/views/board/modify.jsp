<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 포맷팅 관련 태그라이브러리(JSTL/fmt) --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://code.jquery.com/jquery-3.5.1.slim.js" integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM=" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form  action="<c:url value='/board/modify2'/>" method="post"> 
<div>
<label>작성자</label>
<input type = "text" name = 'writer' value ="${login.name}" readonly>
</div>

<div>
<label>제목</label>
<input type = "text" name = 'title' value ="${article.title}" >
</div>

<div>
<label>글내용</label>
<textarea rows= "5" name = 'content' >${article.content}</textarea>
</div>

<input type = "submit" value = "수정하기 ">
</form>
<input type= "button" value = "게시판 돌아가기" id = "cancel">



<script>
$(function() {
$("#cancel").click(function(){
	

	
	location.href = "/board/list";
			
	
});
});

</script>	

</body>
</html>