<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<html>
	<jsp:include page="header.jsp"/>
	<body>
		
		<div style="align: right;">
			<form action="j_spring_security_logout">
				<button  type="submit">Logout</button>
			</form>
		</div>
		
		<div class="grid_12" id="customersList">
			
			<!--  -->
			<div class="grid_12">
				<button id="addButton" type="submit">Add new customer</button>
			</div>
			
			<div class="grid_12">
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
					          	<td><fmt:formatDate value="${customer.dateOfBirth}" var="dateString" pattern="dd.MM.yyyy" /></td>
					          	<td><button id="editButton" type="submit" customerId="${customer.id}">Edit</button></td>
					          	<td><button id="dleteButton" type="submit"  customerId="${customer.id}">Delete</button></td>
					        </tr>
				        </c:forEach>
	       			</tbody>
	     		</table>
	     	</div>
	    </div>
     	
     	<div id="dialog"></div>
	</body>
	
</html>
