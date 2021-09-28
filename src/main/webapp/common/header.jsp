<style>
	.navbar-dark .navbar-nav .nav-link {
    color: rgba(255,255,255,1);
	}
</style>
<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: tomato">
		<div>
			<a class="navbar-brand" style="font-weight: bold; color: white;"> SHOPPING MALL</a>
		</div>

		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%= request.getContextPath() %>/login" class="nav-link">Login</a></li>
			<li><a href="<%= request.getContextPath() %>/register" class="nav-link">Signup</a></li>
		</ul>
	</nav>
</header>