<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<html>
	<jsp:include page="header.jsp"/>
	<body>
		<h2>${helloMessage}</h2>
		<jsp:include page="footer.jsp"/>
	</body>
</html>
