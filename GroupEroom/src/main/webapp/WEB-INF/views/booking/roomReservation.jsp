<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel=" shortcut icon" href="image/favicon.ico">

        <link rel="stylesheet" href="resources/vendor/css/fullcalendar.min.css"/>
        <link rel="stylesheet" href="resources/vendor/css/bootstrap.min.css">
        <link rel="stylesheet" href='resources/vendor/css/select2.min.css'/>
        <link rel="stylesheet" href='resources/vendor/css/bootstrap-datetimepicker.min.css'/>

        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Open+Sans:400,500,600">
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <link rel="stylesheet" href="resources/css/roomReservation.css">
</head>
<body>
<section id="container">
			<jsp:include page="../common/header.jsp"></jsp:include>
		<!--헤더 끝-->
		<!--사이드바 시작-->
		<jsp:include page="../common/sideBar.jsp"></jsp:include>
		<div id="wrapper">
        	<div id="loading"></div>
        	<div id="calendar"></div>
        </div>
        
        <div class="time-set-wrap">
            <div class="time-set-title">
                <span>예약 가능 시간</span>
            </div>
            <div class="time-set-body">
                <div class="time-set" id="time-09s">
                    <a tabindex="-1" href="#">09시</a>
                </div>
                <div class="time-set" id="time-10s">
                    <a tabindex="-1" href="#">10시</a>
                </div>
                <div class="time-set" id="time-11s">
                    <a tabindex="-1" href="#">11시</a>
                </div>
                <div class="time-set" id="time-12s">
                    <a tabindex="-1" href="#">12시</a>
                </div>
                <div class="time-set" id="time-13s">
                    <a tabindex="-1" href="#">13시</a>
                </div>
                <div class="time-set" id="time-14s">
                    <a tabindex="-1" href="#">14시</a>
                </div>
                <div class="time-set" id="time-15s">
                    <a tabindex="-1" href="#">15시</a>
                </div>
                <div class="time-set" id="time-16s">
                    <a tabindex="-1" href="#">16시</a>
                </div>
                <div class="time-set" id="time-17s">
                    <a tabindex="-1" href="#">17시</a>
                </div>
            </div>
        </div>

        <div class="contents-wrap">
            <div class="contents-body">
                <div>
                    <span>회의실 </span>
                    <select id="edit-title" name="edit-title">
                        <option >--회의실 선택--</option>
                        <option value="101Room">101호 회의실</option>
                        <option value="102Room">102호 회의실</option>
                        <option value="103Room">103호 회의실</option>
                        <option value="201Room">201호 회의실</option>
                        <option value="202Room">202호 회의실</option>
                        <option value="203Room">203호 회의실</option>
                    </select>
                    <!-- <input
                        class="inputModal"
                        type="text"
                        name="edit-title"
                        id="edit-title"
                        required="required"
                        placeholder="일정명을 입력해주세요"/> -->
                </div>
                <div class="row">
                    <div class="col-xs-4">
                        <label class="col-xs-4" for="edit-desc">설명</label>
                        <textarea rows="4" cols="50" class="inputModal" name="edit-desc" id="edit-desc"></textarea>
                    </div>
                </div>
            </div>
            <div class="modal-footer modalBtnContainer-addEvent">
                <button type="button">취소</button>
                <button type="button" id="save-event">저장</button>
            </div>
            <div class="modal-footer modalBtnContainer-modifyEvent">
                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-danger" id="deleteEvent">삭제</button>
            </div>
        </div>
        <script src="resources/vendor/js/jquery.min.js"></script>
        <script src="resources/vendor/js/bootstrap.min.js"></script>
        <script src="resources/vendor/js/moment.min.js"></script>
        <script src="resources/vendor/js/fullcalendar.min.js"></script>
        <script src="resources/vendor/js/ko.js"></script>
        <script src="resources/vendor/js/select2.min.js"></script>
        <script src="resources/vendor/js/bootstrap-datetimepicker.min.js"></script>
        <script src="resources/js/main.js"></script>
        <script src="resources/js/addEvent.js"></script>
        <script src="resources/js/editEvent.js"></script>
        <script src="resources/js/etcSetting.js"></script>
        <script src="resources/js/focus.js"></script>

        <script>

$('.time-set').click(function() {

    $('.time-set').removeClass('click')
    $(this).addClass('click');


});
        </script>
        </section>
</body>
</html>