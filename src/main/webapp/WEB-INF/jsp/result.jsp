<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta name="viewport" content="width=device-width">
	<style type="text/css">
body {
	background-color: #e6e6e6;
	margin-left : 20%;
	margin-right: 20%;
}

.main {
    text-align: center;
}

.grid{
  float: left;
  background:#ffffff;
  color:#000000;
  margin: 5px;
  padding:2px;
  word-wrap: break-word;
}

.destination_Station{
	width : 100%;
}

@media screen and (max-width : 1080px){
	.grid {
		width:96%;
	}
}
@media screen and (min-width : 1081px){
	.grid {
		width:20%;
	}
}
	</style>

<title>結果表示画面</title>
</head>
  <body>

    <div class="main">
  	   <div class="destination_Station">
    	    <h1>待ち合わせ駅：	<c:out value="${it.destinationStationName}" /><br>
              <c:out value="${it.meetingTime.month}" />月<c:out value="${it.meetingTime.day}" />日<br>
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

      <div class="grid">
        <P>hoge駅</P>
        出発時刻:00：00<br>
        運賃：〇〇円
      </div>
   </div>



 </body>
</html>
