<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 포맷팅 관련 태그라이브러리(JSTL/fmt) --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.5.1.slim.js" integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM=" crossorigin="anonymous"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<label>작성자</label>
<input type = "text" name = 'writer' value ="${article.writer}" readonly>
</div>

<div>
<label>제목</label>
<input type = "text" name = 'title' value ="${article.title}" readonly>
</div>

<div>
<label>글내용</label>
<textarea rows= "5" name = 'content' readonly>${article.content}</textarea>
</div>


<c:if test = "${article.writer == login.name}">

<form  action="<c:url value='/board/delete'/>" method="post"> 
<input type = "hidden" name = "boardNo" value = "${article.boardNo}">
<input type="submit" value = "삭제">
</form>



<form  action="<c:url value='/board/modify'/>" method="post"> 
<input type = "hidden" name = "boardNo" value = "${article.boardNo}">
<input type="submit" value = "수정하기">
</form>
</c:if>


<input type= "button" value = "게시판 돌아가기" id = "canel">



<script>
$(function() {
$("#canel").click(function(){
	

	
	location.href = "/board/list";
			
	
});
});

</script>	


</script>

</body>
</html>