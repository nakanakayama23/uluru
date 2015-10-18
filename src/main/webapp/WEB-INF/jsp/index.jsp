<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Hello World!</h2>
<c:forEach begin="1" end="4" varStatus="status">
  <h3>${it} : <c:out value="${status.index}"/></h3>
</c:forEach>
</body>
</html>