<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles/addnote.css">
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
		<section id="note-form">
			<form action="AddNotes">
				<h2>Add Notes</h2>
				<%
				String added = (String) session.getAttribute("added");
				if (added != null) {
				%>
				<p style="color: rgb(70, 220, 70); text-align: center; margin-top: .5rem"><%= added %></p>
				<%
				session.removeAttribute("added");
				}
				%>
				<label for="title">Title</label> <input type="text" id="title"
					placeholder="Enter Title" name="title" /> <label>Note</label>
				<textarea placeholder="Write your notes" name="notes"></textarea>

				<button>Add</button>
			</form>
		</section>
	</div>
</body>
</html>