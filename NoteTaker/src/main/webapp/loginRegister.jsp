<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles/LoginRegister.css">
</head>
<body>
	<section id="nav-bar">
		<div id="logo">
			<a href="index.jsp"><img id="nav-logo" src="img/to-do-list.jpg"
				alt=""></a>
			<h2>To-Do-List</h2>
		</div>
	</section>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action="Register" method="get">
				<h1>Create Account</h1>
				<%
				String success = (String) session.getAttribute("success");
				if (success != null) {
				%>
				<p style="color: green;"><%=success%></p>
				<%
				session.removeAttribute("success");
				}
				%>
				<input type="text" placeholder="Name" name="name" /> <input
					type="email" placeholder="Email" name="email" /> <input
					type="password" placeholder="Password" name="password" />
				<button type="submit">Sign Up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action="Login" method="get">
				<h1>Sign in</h1>
				<%
				String msg = (String) session.getAttribute("error");
				if (msg != null) {
				%>
				<p style="color: red;"><%=msg%></p>
				<%
				session.removeAttribute("error");
				}
				%>
				
				<%
				String logoutMsg = (String) session.getAttribute("logoutMsg");
				if (logoutMsg != null) {
				%>
				<p style="color: green;"><%=logoutMsg%></p>
				<%
				session.removeAttribute("logoutMsg");
				}
				%>
				<input type="email" placeholder="Email" name="email" /> <input
					type="password" placeholder="Password" name="password" /> <a
					href="#">Forgot your password?</a>
				<button>Sign In</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To keep connected with us please login with your personal
						info</p>
					<button class="ghost" id="signIn">Sign In</button>
					<a href="index.jsp" class="home-btn">Home</a>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Enter your personal details and start journey with us</p>
					<button class="ghost" id="signUp">Sign Up</button>
					<a href="index.jsp" class="home-btn">Home</a>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="scripts/LoginRegister.js"></script>
</html>