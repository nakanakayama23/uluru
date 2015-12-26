<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.uluru.utils.Constant" %>
<html>
<head>
<title>メインメニュー</title>
<script type="text/javascript">
function setCurrentDate(){
	currentD = new Date();

	currentYear    = currentD.getFullYear();
	currentMonth   = currentD.getMonth() + 1;
	currentDate    = currentD.getDate();
	currentHours   = currentD.getHours();
	currentMinutes = currentD.getMinutes();

	/* 集合日時の年プルダウンリストに今年と来年の値を設定 */
	var select = document.getElementById('year');

	for (var i = currentYear; i < currentYear + 2; i++) {
	    var option = document.createElement('option');
	 
	    option.setAttribute('value', i);
	    option.innerHTML = i;
	 
	    select.appendChild(option);
	}

}
</script>
</head>
<body>
<h2>メインメニュー</h2>
<form method="GET" action="<%= request.getContextPath() %>/confirm">
集合日時：
<select name="year" id="year">
</select>年
<select name="month" id="month">
	<c:forEach var="month"  begin="1" end="12" step="1">
		<option value="${month}" >${month}</option>
	</c:forEach>
</select>月
<select name="day" id="date">
	<c:forEach var="date"  begin="1" end="31" step="1">
		<option value="${date}" >${date}</option>
	</c:forEach>
</select>日
<select name="hour" id="hour">
	<c:forEach var="hour"  begin="0" end="23" step="1">
		<option value="${hour}" >${hour}</option>
	</c:forEach>
</select>時
<select name="minute" id="minute">
	<c:forEach var="minute"  begin="0" end="59" step="1">
		<option value="${minute}" >${minute}</option>
	</c:forEach>
</select>分
<br>

<script>
	setCurrentDate();
</script>

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