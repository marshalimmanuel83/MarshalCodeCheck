<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Module</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- add a button to Add Customer -->
			<input type="button" value="Add Customer" 
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
			/>
			
			<form:form action="search" method="GET">
			Search Customer: <input type="text" name="theSearchName" />
			<input type="submit" value="Search" class="add-button" />
			</form:form>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print the customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
					<!-- jstl logic to get the customer id for update while clicking the Update link in a record -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
					
					<!-- jstl logic to get the customer id for delete while clicking the Update link in a record -->
					<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
				
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- display a link for update customer -->
							<a href="${updateLink}">Update</a>
							|
							<!-- display a link for delete customer -->
							<a href="${deleteLink}" 
								onclick="if (!(confirm('Do you want to delete the customer?'))) return false">Delete</a>
						</td>
					</tr>				
				</c:forEach>
				
			</table>
		</div>
	</div>
	
</body>
</html>