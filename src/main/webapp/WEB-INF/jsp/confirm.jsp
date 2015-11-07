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

集合日時：	<input type="text" name="year" value="2015">年
		<input type="text" name="month" value="10">月
		<input type="text" name="day" value="25">日
		<input type="text" name="hour" value="18">時
		<input type="text" name="minute" value="30">分
		<br>
	<br/><br/>
	
	<c:forEach items="${it.inputStationItemList}" var="item">
		駅${item.number}
		<select name="${item.number}">
			<c:forEach var="candidate" items="${item.stationList}">
				<option value="${candidate.id}" >${candidate.name}</option>
			</c:forEach>
		</select>
		<br/>
    </c:forEach>

</form>

</body>
</html>