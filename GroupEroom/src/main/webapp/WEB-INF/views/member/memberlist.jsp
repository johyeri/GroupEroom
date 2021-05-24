<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록 조회</title>
<style type="text/css">
   .centerText table {
      margin : auto;
   }
   span.guide {
      display : none;
      font-size : 12px;
      top : 12px;
      right : 10px;
   }
   span.ok{color:green}
   span.error{color:red}
</style>

</head>
<body>
<!-- 헤더 시작 -->
		<jsp:include page="../common/header.jsp"></jsp:include>
		<!-- 헤더 끝 -->
		<!-- 사이드바 시작 -->
		<jsp:include page="../common/sideBar.jsp"></jsp:include>
		<!-- 사이드바 끝  -->
	
       <section id="main-content">
      <section class="wrapper">
	<h1 align="center">사원 목록 </h1>
	<div class="centerText">
      <form action="memberModify.do" method="post">
	<table border="1" width="650px" cellspacing="5">
	<tr>
		<th>사번</th>
		<th>부서</th>
		<th>직급</th>
		<th>이름</th>
	
	
	</tr>
	<c:forEach var="row" items="${list }">
	<tr>
		<td>${row.memberId }</td>
		<td>${row.memberDept }</td>
		<td>${row.memberJob }</td>
		<td>${row.memberName }</td>
		
	</tr>
	</c:forEach>
	</section>
	</section>
	</div>
	</form>
	</table>
</body>
</html>