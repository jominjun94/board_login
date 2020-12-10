<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 포맷팅 관련 태그라이브러리(JSTL/fmt) --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.slim.js" integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<span style = "color:#0000FF">조민준</span>게시판
<span id = "counter-per-page" style ="float:right;">
	<input class ="btn" type = "button" value ="10">
	<input class ="btn" type = "button" value ="20">
	<input class ="btn" type = "button" value ="30">
</span>

<table width = "500" boarder ="15" bordercolor = "blue" align = "center">
	<tr style = "background-color:#0000FF; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">
		<td>No</td>
		<td>작성자</td>
		<td>제목</td>
		<td>내용</td>
		<td>조회수</td>
	</tr>

	<c:forEach var = "article" items = "${articles}">
	
	
		<c:if test = "${articles.size() > 0}">
	<tr>
		<td> ${article.boardNo} </td>
		<td> ${article.writer} </td>
		<td> 
		<a href ="<c:url value = '/board/content/${article.boardNo}'/>">
		${article.title}
		</a>
		
		
		</td>
		<td> ${article.content} </td>
		 <td> ${article.viewCount} </td>
		
	</tr>
		</c:if>
		
		<c:if test="${articles.size() <= 0}">
	<tr>
		<td colspan="5" align="center">
			검색 결과가 없습니다!!
		</td>
	</tr>
		</c:if>
		
			</c:forEach>
		<tr style = "background-color:skyblue;">
		<td> 
		  	<c:if test="${pc.prev}">
		<a href="<c:url value = '/board/list?page=${pc.beginPage - 1}'/>">이전</a>
		</c:if>
		</td>
		<td colspan="2" align="center"> 
		<c:forEach var ="num" begin = "${pc.beginPage}" end ="${pc.endPage}">
	
			<a href="<c:url value = '/board/list?page=${num}'/>">${num}</a>
		<!--  condition 이랑 keyword 값 붙여서보내주기 -->
		</c:forEach>
		 </td>
		<td>
	 <c:if test="${pc.next}">
		<a href="<c:url value = '/board/list?page=${pc.endPage + 1}'/>">다음</a>
		</c:if>
		</td>
		
		</tr>
		

</table>


		<select  id = "condition">
			<option value = "title">제목</option>
			<option value = "content">내용</option>
			<option value = "writer">작성자</option>
			<option value = "titleContent">제목 + 작성자</option>
		</select>
		
		<input type = "text" name = "keyword"  id = "keywordIn" placeholder= "검색어작성">
		<input type = button value= "검색" id="searchBtn">
		
		<c:if test = "${login != null}">
		<input type = button value= "글쓰기" id="writeBtn">
		</c:if>
		
		<input type = button value= "회원가입" id="logBtn">
		
		<c:if test = "${login == null}">
		<input type = button value= "로그인" id="loginBtn">
		</c:if>
		
		<c:if test = "${login != null}">
		<input type = button value= "로그아웃" id="logoutBtn">
		</c:if>
		
		
		
		<c:if test = "${login != null}">
		<p>${login.name}님 게시판에 로그인 해주셔서 감사합니다 </p>
		</c:if>
		
		<c:if test = "${login == null}">
		<p>
		<strong>>로그인을 하셔야 게시글을 작성할수 있습니다 </strong>>
		 </p>
		</c:if>
	
	
	
	
	
	
	
	
	

	
<script>





const result = "${msg}";

if(result === "regSuccess") {
	alert("게시글 등록이 완료되었습니다.");
} else if(result === "delSuccess") {
	alert("게시글 삭제가 완료되었습니다.");
}




$(function() {
$("#searchBtn").click(function(){
	
	 const con = $("#condition option:selected").val();
	const key = $("#keywordIn").val()
	
	location.href = "/board/list?keyword=" +  key
			+"&condition="+ con;
	
});

$("#counter-per-page .btn").click(function(){
	let count = $(this).val();
	location.href = "/board/list?counterPerPage="+count;
	
});


$("#writeBtn").click(function(){
	
	
	
	location.href = "/board/write";
		
	
});


$("#logBtn").click(function(){
	
	
	
	location.href  = "/user/log";
		
	
});

$("#loginBtn").click(function(){
	
	
	
	location.href  = "/user/login";
		
	
});


$("#logoutBtn").click(function(){
	
	
	
	location.href  = "/user/logout";
		
	
});





});




</script>	
	
		
</body>
</html>



