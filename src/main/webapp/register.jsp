<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Mall</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
 crossorigin="anonymous">
</head>

</head>
<body style="background: #f6f8e8;">
<jsp:include page="common/header.jsp"></jsp:include>
 <div class="container">
 <div  style="color: #4169E1; text-align: center; margin-top: 5px;">
  <h2> Register </h2>
 </div>
 <hr>
  <div style="width: 50%; margin: 0 auto;" > 
   
   <div class="card card-body">
   
    <div class="col-lg-12 ">

     <form action="<%=request.getContextPath()%>/register" method="post">

      <div>
       <label for="name">Name:</label> 
       <input type="text"
        class="form-control" id="name" placeholder="Full Name"
        name="name" required />
      </div>
      <br>

      <div class="form-group">
       <label for="type">Type:</label>
       <br />
        <input type="radio" id="type" name="type" value="customer">Customer
        <br>
		<input type="radio" id="type" name="type" value="employee">Employee
		<br>
		<input type="radio" id="type" name="type" value="malladmin">Mall Admin
		<br>
		<input type="radio" id="type" name="type" value="shopowner">Shop Owner
		<br>
      </div>

      <div class="form-group">
       <label for="uname">Password:</label> <input type="password"
        class="form-control" id="password" placeholder="Password"
        name="password" required>
      </div>

      <button type="submit" class="btn btn-primary">Register</button>
     </form>
    </div>
   </div>
  </div>
 </div>
 <jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>