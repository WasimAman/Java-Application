<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles/profiles.css">
</head>
<body>
	<div class="container">
		<section id="nav-bar">
			<div id="logo">
				<a href="#"><img id="nav-logo" src="img/to-do-list.jpg" alt=""></a>
				<h2>To-Do-List</h2>

				<div class="functions">
					<a href="addnotes.jsp" class="user-btn">add notes</a> <a
						href="ShowNotes" class="user-btn">show notes</a> <a
						href="profile.jsp" class="user-btn">profile</a>
				</div>
			</div>

			<div id="btns">
				<ul>
					<li><a href="Logout">log out</a></li>
				</ul>
			</div>
		</section>
		<%
		User user = (User)session.getAttribute("user");
		%>
		<section class="hero-section">
			<table class="flat-table flat-table-1">
				<tbody>
					<tr>
						<td id="bold-td">ID</td>
						<td><%= user.getId() %></td>
					</tr>
					<tr>
						<td id="bold-td">NAME</td>
						<td><%= user.getName() %></td>
					</tr>
					<tr>
						<td id="bold-td">EMAIL</td>
						<td><%= user.getEmail() %></td>
					</tr>
					<tr>
						<td id="bold-td">PASSWORD</td>
						<td><%= user.getPassword() %></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;"><a href="shownotes.jsp">Notes</a></td>
					</tr>
				</tbody>
			</table>
		</section>
	</div>
</body>
</html>