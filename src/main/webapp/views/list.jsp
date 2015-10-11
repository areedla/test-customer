<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>
<html>
	<jsp:include page="header.jsp"/>
	<body>
		
		<div class="container_12" id="customersList">
			<div class="grid_12">
				<c:if test="${!msg.equals('')}"> 
					<div class="grid_12">
						<c:out value="${msg}"/>
					</div>
				</c:if>
				<div class="grid_12 paddingTop10">
				
					<input type="button" id="addButton" style="float: left;" value="Add new customer"/>

					 	
					<form:form action="<c:url value='/j_spring_security_check' />" method='POST'>
						<input type="submit"  style="float: right;" value="Logout"/>
					</form:form>
				</div>
			</div>
			
			<div class="grid_12 height300">
				
				<c:if test="${allCustomers != null and allCustomers.size() > 0}"> 
					<div class="grid_12 center">
						<table>
			       			<thead>
			         			<tr>
			          				<th> First Name </th>
			          				<th> Last name </th>
			          				<th> Username </th>
			          				<th> Date of birth </th>
			          				<th> Edit </th>
			          				<th> Delete </th>
			         			</tr>
			        		</thead>
			        		<tbody>
						        <c:forEach var="customer" items="${allCustomers}">
							        <tr>
							          	<td><c:out value="${customer.firstName}"/></td>
							          	<td><c:out value="${customer.lastName}"/></td>
							          	<td><c:out value="${customer.userName}"/></td>
							          	<td><c:out value="${customer.getDateOfBirthString()}"/></td>
							          	<td><button class="center" id="editButton" type="button" customerId="${customer.id}">Edit</button></td>
							          	<td>
							          		<form action="/Customer/deleteCustomer?id=${customer.id}">
							          			<button class="center" id="deleteButton" type="submit">Delete</button>
							          		</form>
							          	</td>
							        </tr>
						        </c:forEach>
			       			</tbody>
			     		</table>
			     	</div>
		     	</c:if> 
		    </div>
	     	
	     	<div id="dialog" style="display:none"></div>
	     </div>
	     
	     <jsp:include page="footer.jsp"/>
	</body>
	
</html>
