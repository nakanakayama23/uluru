<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.uluru.utils.Constant" %>
<html>
<head>
<title>メインメニュー</title>
</head>
<body>

<h2>メインメニュー</h2>

<form method="GET" action="<%= request.getContextPath() %>/confirm">

集合日時：	<input type="text" name="year" value="2015">年
		<input type="text" name="month" value="10">月
		<input type="text" name="day" value="25">日
		<input type="text" name="hour" value="18">時
		<input type="text" name="minute" value="30">分
		<br>
	
<table>
	<c:forEach begin="1" end="<%=Constant.MAX_STATION_NUMBER %>" varStatus="status">
   		<tr>
   			<td> 駅<c:out value="${status.index}" /> </td>
   			<td> <input type="text" name="stationList"> </td>
   		</tr>
	</c:forEach>
</table>
<br>

<input type="submit" value="送信">

</form>

</body>
</html>