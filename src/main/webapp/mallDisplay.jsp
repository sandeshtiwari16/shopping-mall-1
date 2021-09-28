<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Shopping Mall</title>

	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
	a{
		color: white;
	}
	.navbar-dark .navbar-nav .nav-link {
    color: rgba(255,255,255,1);
	}
</style>
</head>
<body style="background: #f6f8e8;">

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div style="font-weight:bold; margin-right:50px;">
				 <h2 class="navbar-brand">SHOPPING MALL</h2>
			</div>
			<ul class="navbar-nav">
				<li><a href="home.jsp"
					class="nav-link">Home</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="mallIndex.jsp"
					class="nav-link">Customer</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="employeeIndex.jsp"
					class="nav-link">Employee</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="itemIndex.jsp"
					class="nav-link">Item</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="mallIndex.jsp"
					class="nav-link">Mall</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="shopIndex.jsp"
					class="nav-link">Shop</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="ownerIndex.jsp"
					class="nav-link">Owner</a></li>
			</ul>
			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="index.jsp"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<center>
        <h4 style="font-family: Arial, Helvetica, sans-serif; margin-top: 2%;">
		<div class="container">
			<a href="mall?action=new" class="btn btn-info">Add New Mall</a>
		</div>       	
        </h4>
        <hr>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <h2>List of Malls</h2>
            <br>
            <tr>
                <th>ID</th>
                <th>Admin</th>
                <th>Mall Name</th>
                <th>Location</th>
                <th>Category</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="mall" items="${listMall}">
                <tr>
                    <td><c:out value="${mall.id}" /></td>
                    <td><c:out value="${mall.name}" /></td>
                    <td><c:out value="${mall.college}" /></td>
                    <td><c:out value="${mall.roll}" /></td>
                    <td><c:out value="${mall.qualification}" /></td>
                    <td>
                    	<button class="btn btn-success"><a style="color:white;" href="mall?action=edit&id=<c:out value='${mall.id}' />">Edit</a></button>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<button class="btn btn-danger"><a style="color:white;" href="mall?action=delete&id=<c:out value='${mall.id}' />" onclick="return confirm('Do you want to delete?')">Delete</a></button>                            	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
        <jsp:include page="common/footer.jsp"></jsp:include>	
</body>
</html>
