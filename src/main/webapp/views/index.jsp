<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="false"%>
<html>
	<jsp:include page="header.jsp"/>
	<body>
		
		<!-- Just a creeting text. This can by menu or some banner and in most cases is in header -->
		<h2>${helloMessage}</h2>
		
		<div class="container_12">
			<div class="grid_12">
				<div class="center paddingTop90">
					<form action="list">
					    <button  type="submit">Add and edit customers</button>
					</form>
				</div>
				<div class="clear"></div>
				<div class="center paddingTop20">Only authorized persons can enter.</div>
				<!-- the authetication system is under developement -->
			</div>
		</div>
		
		<jsp:include page="footer.jsp"/>
	</body>
</html>
