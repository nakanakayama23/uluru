<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>入力データ確定画面</title>
</head>
<body>

	<h2>入力データ確定画面</h2>
	
<form method="GET" action="<%= request.getContextPath() %>/search">

集合日時：	<c:out value="${it.meetingTime.year}" />年
		<c:out value="${it.meetingTime.month}" />月
		<c:out value="${it.meetingTime.day}" />日
		<c:out value="${it.meetingTime.hour}" />時
		<c:out value="${it.meetingTime.minute}" />分
		<br><br><br>
		<input type="hidden" name="year" value="${it.meetingTime.year}" />
		<input type="hidden" name="month" value="${it.meetingTime.month}" />
		<input type="hidden" name="day" value="${it.meetingTime.day}" />
		<input type="hidden" name="hour" value="${it.meetingTime.hour}" />
		<input type="hidden" name="minute" value="${it.meetingTime.minute}" />

	<c:forEach items="${it.inputStationItemList}" var="item">
		駅<c:out value="${item.number}" />
		<select name="station<c:out value="${item.number}" />">
			<c:forEach var="candidate" items="${item.stationList}">
				<option value="${candidate.id}" ><c:out value="${candidate.name}" /></option>
			</c:forEach>
		</select>
		<br>
    </c:forEach>
    <br><br>
    
    <input type="submit" value="送信する">

</form>

</body>
</html>