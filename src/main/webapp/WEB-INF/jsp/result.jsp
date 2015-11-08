<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>結果表示画面</title>
</head>
<body>

	<h2>結果表示画面</h2>
	
	集合駅：	<c:out value="${it.destinationStationName}" />
			<br><br><br>
	
	集合日時：	<c:out value="${it.meetingTime.year}" />年
			<c:out value="${it.meetingTime.month}" />月
			<c:out value="${it.meetingTime.day}" />日
			<c:out value="${it.meetingTime.hour}" />時
			<c:out value="${it.meetingTime.minute}" />分
			<br><br><br>
	
	
	<table style="border-style: solid; border-color: black">
		<tr>
			<th>入力順</th>
			<th>出発駅</th>
			<th>出発時刻</th>
			<th>運賃</th>
		</tr>
	<c:forEach items="${it.departureStationList}" var="station" varStatus="status">
		<tr
			<c:if test="${(status.count + 1) % 2 == 0}"> bgcolor="pink" </c:if>
		>
			<td><c:out value="${station.number}" /></td>
			<td><c:out value="${station.departureStationName}" /></td>
			<td>
				<c:out value="${station.departureTime.year}" />年
				<c:out value="${station.departureTime.month}" />月
				<c:out value="${station.departureTime.day}" />日
				<c:out value="${station.departureTime.hour}" />時
				<c:out value="${station.departureTime.minute}" />分
			</td>
			<td><c:out value="${station.fare}" />円</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>