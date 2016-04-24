<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.uluru.utils.Constant" %>
<html>
	<head>
	<title>メインメニュー</title>
		<script src="/uluru-1.0/js/input_form.js"></script>
		<link rel="stylesheet" type="text/css" href="/uluru-1.0/css/input_form.css">
		<link rel="stylesheet" type="text/css" href="/uluru-1.0/css/header.css">
		<script type="text/javascript" src="/uluru-1.0/js/common.js"></script>
	</head>
	<body>
		<div class="headerArea">
			<script type="text/javascript" src="/uluru-1.0/js/header.js"></script>
		</div>
		<div class="body_content">
			<h1>Ulururu</h1>
			<h2>～ みんな平等 ～</h2>
			<form name="inputForm" method="GET" action="<%= request.getContextPath() %>/confirm">
				集合日時：
				<select name="year" id="year">
				</select>年
				<select name="month" id="month">
					<c:forEach var="month"  begin="1" end="12" step="1">
						<option value="${month}" >${month}</option>
					</c:forEach>
				</select>月
				<select name="day" id="date" onFocus="chg_date_selection()">
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
				<br><br>

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
				<input type="submit" value="集合駅を検索">
			</form>
		</div>
	</body>
</html>