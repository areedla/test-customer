<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>
<html>
	<jsp:include page="header.jsp"/>
	<body>
		
		<div class="container_12" id="customersList">
			<div class="grid_12">
				<c:if test="${!msg.equals('')}"> 
					<div style="color:red; font-weight:bold;">
						<c:out value="${msg}"/>
					</div>
				</c:if>
				<div class="paddingTop5">
				
					<input type="button" id="addButton" style="float: left;" value="Add new customer"/>

					 	
					<form:form action="<c:url value='/j_spring_security_check' />" method='POST'>
						<input  id="logOutButton" type="submit"  style="float: right;" value="Logout"/>
					</form:form>
				</div>
			</div>
			
			<div class="grid_12 textCenter height300 textCenter center">
				
				<c:if test="${allCustomers != null and allCustomers.size() > 0}"> 
					<div class="lightYellow">
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
							          	<td class="textCenter"><button id="editButton" type="button" customerId="${customer.id}">Edit</button></td>
							          	<td class="textCenter" >
							          		<form action="deleteCustomer" style="padding-top:14px">
							          			<input type="hidden" name="id" value="<c:out value='${customer.id}'/>"/>
							          			<input class="center" id="deleteButton" type="submit" value="Delete"/>
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
