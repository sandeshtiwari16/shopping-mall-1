<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Mall</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
	button {
	  background-color: white;
	  color: black;
	  border: 2px solid #4CAF50; /* Green */
	  border-radius: 12px;
	}
	button:hover {
	  background-color: #4CAF50;
	  color: white;
	  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
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
				<li><a href="customerIndex.jsp"
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
	
	 <div class="container" style="width: 80%; margin: 0 auto;">
	 <div class="row col-lg-12">
	  <div class="card card-body" style="margin-top:10%;">
	   <h2 align="center" style="color: #4169E1;">Perform CRUD Operations</h2>
	   <hr>
		<div class="btn-group" style="justify-content:center;">
		  <button style="width:15%; margin-right:5px;" onclick="window.location.href = 'customerIndex.jsp';">Customer</button>
		  <button style="width:15%; margin-right:5px;" onclick="window.location.href = 'employeeIndex.jsp';">Employee</button>
		  <button style="width:15%; margin-right:5px;" onclick="window.location.href = 'itemIndex.jsp';">Item</button>
		  <button style="width:15%; margin-right:5px;" onclick="window.location.href = 'mallIndex.jsp';">Mall</button>
		  <button style="width:15%; margin-right:5px;" onclick="window.location.href = 'shopIndex.jsp';">Shop</button>
		  <button style="width:15%; margin-right:5px;" onclick="window.location.href = 'ownerIndex.jsp';">Owner</button>
		</div>
	  </div>
	 </div>
	</div>
	
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>