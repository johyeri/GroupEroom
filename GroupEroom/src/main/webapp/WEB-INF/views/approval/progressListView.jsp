<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전자결재 - 진행함</title>
</head>
<body>
<section id="container">
		<!-- 헤더 시작 -->
		<jsp:include page="../common/header.jsp"></jsp:include>
		<!--헤더 끝-->
		<!--사이드바 시작-->
		<jsp:include page="../common/sideBar.jsp"></jsp:include>
		<!-- **********************************************************************************************************************************************************
        메인 콘텐츠
        *********************************************************************************************************************************************************** -->
		<!-- 메인 콘텐츠 -->
		<section id="main-content">
			<section class="wrapper site-min-height">
			<h3><i class="fa fa-angle-right"></i> 전자결재</h3>
        <div class="row">
          <div class="col-md-12">
            <div class="content-panel">
              <h4><i class="fa fa-angle-right"></i> 진행함</h4>
                <hr>
                <div class="form-group" align="right">
                <form action="cBoardSearch.do" method="get" class="form-inline" role="form">
                <select class="form-control" name="searchCondition">
                	<option value="ALL">전체</option>
                	<option value="C_BOARD_TITLE">제목</option>
                	<option value="C_BOARD_CONTENTS">내용</option>
                	<option value="MEMBER_NAME">작성자</option>
                </select>
                <input type="text" name="searchValue" style="width:100px" class="form-control" >
                <input type="submit" value="검색" class="btn btn-theme">
                </form>
                </div>
                
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th>문서번호</th>
                    <th>유형</th>
                    <th>문서제목</th>
                    <th>기안자</th>
                    <th>중간 결재자</th>
                    <th>최종 결재자</th>
                    <th>상태</th>
                    <th>기안일자</th>
                    
                  </tr>
                </thead>
                <tbody>
					<c:forEach items="${aList }" var="approval">
						<tr>
							<td>${approval.approvalNo }</td>
							<c:if test="${approval.approvalType == 'Cooperation' }">
								<td>협조문</td>
							</c:if>
							<td>${approval.approvalTitle }</td>
							<td>${userName }</td>
							<td>${approval.approvalFirstName }</td>
							<td>${approval.approvalSecondName }</td>
							<c:if test="${approval.approvalState == 'N' }">
							<td>미열람</td>
							</c:if>
							<td>${approval.approvalDate }</td>
						</tr>
					</c:forEach>
               </tbody>
            </table>
            <div align="center">
            <div class="btn-group">
						<!-- 이전 -->
						<c:url var="before" value="cBoardListView.do">
							<c:param name="page" value="${pi.currentPage - 1 }"></c:param>
						</c:url>
						<c:if test="${pi.currentPage <= 1 }">
							<button type="button" class="btn btn-default">이전</button>
						</c:if>
						<c:if test="${pi.currentPage > 1 }">
							<a href="${before }" class="btn btn-default">이전</a>&nbsp;
						</c:if>
						
					<!-- 페이지 -->
					<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
						<c:url var="pagination" value="cBoardListView.do">
							<c:param name="page" value="${p }"></c:param>
						</c:url>
						<c:if test="${p eq pi.currentPage }">
						<button type="button" class="btn btn-default btn-theme">${p }</button>
							
						</c:if>
						<c:if test="${p ne pi.currentPage }">
							<a href="${pagination }" class="btn btn-default">${p }</a>&nbsp;
						</c:if>
					</c:forEach>
				
				
				<!-- 다음 -->
				<c:url var="after" value="cBoardListView.do">
					<c:param name="page" value="${pi.currentPage + 1 }"></c:param>
				</c:url>
				<c:if test="${pi.currentPage >= pi.maxPage }">
					<button type="button" class="btn btn-default">다음</button>
				</c:if>
				<c:if test="${pi.currentPage < pi.maxPage }">
					<a href="${after }" class="btn btn-default">다음</a>&nbsp;
				</c:if>
			</div>
			</div>
              <div align="right">
              	<a href="cBoardWriteView.do" class="btn btn-theme02">글 쓰기</a>
              </div>
            </div>
          </div>
        </div>
			
			
			
			</section>
		</section>
		<!-- footer -->
		<footer class="site-footer">
			<div class="text-center">
				<p>
					&copy; Copyrights <strong>Dashio</strong>. All Rights Reserved
				</p>
				<div class="credits">
					<!--
            You are NOT allowed to delete the credit link to TemplateMag with free version.
            You can delete the credit link only if you bought the pro version.
            Buy the pro version with working PHP/AJAX contact form: https://templatemag.com/dashio-bootstrap-admin-template/
            Licensing information: https://templatemag.com/license/
          -->
					Created with Dashio template by <a href="https://templatemag.com/">TemplateMag</a>
				</div>
				<a href="index.html#" class="go-top"> <i class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>
</body>
</html>