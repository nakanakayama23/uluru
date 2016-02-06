<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/uluru-1.0/css/result.css">
		<link rel="stylesheet" type="text/css" href="/uluru-1.0/css/header.css">
		<title>結果表示画面</title>
	</head>
	<body>
		<div class="headerArea">
			<script type="text/javascript" src="/uluru-1.0/js/header.js"></script>
		</div>
		<div class="body_content">

			<div class="main">
				<div class="destination_Station">
				<h1>
				<c:out value="${it.meetingTime.month}" />月<c:out value="${it.meetingTime.day}" />日<br>
				待ち合わせ駅：	<c:out value="${it.destinationStationName}" /><br>
				集合時刻: <c:out value="${it.meetingTime.hour}" />:<c:out value="${it.meetingTime.minute}" />
				</h1>
				</div>
		<c:forEach items="${it.departureStationList}" var="station" varStatus="status">
			<div class="grid">
			<P><c:out value="${station.departureStationName}" /></P>
			出発時刻:<c:out value="${station.departureTime.hour}" />:<c:out value="${station.departureTime.minute}" /><br>
			金額：<c:out value="${station.fare}" />円
			</div>
		</c:forEach>
		</div>
	</body>
</html>