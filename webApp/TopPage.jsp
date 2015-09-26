<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uluru</title>
</head>
<body>
	<h2>Uluru</h2>

	<%
		String answer = "";
		if (request.getAttribute("answer") != null) {
			answer = (String) request.getAttribute("answer");
		}
	%>

	<form method="post" action="TopPage">
		好きな食べ物を選んでください。 <select name="food" onchange="submit()">
			<option value="" <%if (answer.equals("")) {%> selected <%}%>>選択してください</option>
			<option value="ラーメン" <%if (answer.equals("ラーメン")) {%> selected <%}%>>ラーメン</option>
			<option value="カレーライス" <%if (answer.equals("カレーライス")) {%> selected
				<%}%>>カレーライス</option>
			<option value="納豆ごはん" <%if (answer.equals("納豆ごはん")) {%> selected
				<%}%>>納豆ごはん</option>
		</select>
	</form>

	<br>
	<%
		if (!answer.equals("")) {
	%>
	あなたが選択した食べ物は<%=answer%>です。
	<%
		}
	%>
</body>
</html>