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
	body {
	  background-image: url('common/bgnd.jpg');
	  background-repeat: no-repeat;
	  background-attachment: fixed;
	  background-size: cover;
	}
	.card{
	    background-color: rgb(255,255,255,0.7);
	 }
	 button{
	 	margin-left: 43%;
	 }
</style>

</head>
<body>

<div class="container">
  <div style="width: 65%; margin: auto; margin-top: 10%; vertical-align: center;" > 
   
   <div class="card card-body">
   
    <div class="col-lg-12">
	<h1 style="font-family: emoji; font-size: 50px; color: #4B0082; text-align: center;">WELCOME</h1>
	<br>
	<h3 style="font-family:Comic Sans MS; font-size: 24px;text-align: center; color:#2e856e;">"Fashion is what you buy, Style is what you do with it."</h3>
	<br>
    <button class="btn btn-primary" onclick="window.location.href = 'register.jsp';">Let's Shop</button>
    </div>
   </div>
  </div>
 </div>

</body>
</html>