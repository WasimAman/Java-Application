<%@ page import="com.entity.Notes"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>To-Do List</title>
    <link rel="stylesheet" type="text/css" href="styles/shownotes.css">
</head>
<body>
    <div class="container">
        <section id="nav-bar">
            <div id="logo">
                <a href="#"><img id="nav-logo" src="img/to-do-list.jpg" alt="To-Do List"></a>
                <h2>To-Do List</h2>
                <div class="functions">
                    <a href="addnotes.jsp" class="user-btn">Add Notes</a>
                    <a href="ShowNotes" class="user-btn">Show Notes</a>
                    <a href="profile.jsp" class="user-btn">Profile</a>
                </div>
            </div>
            <div id="btns">
                <ul>
                    <li><a href="Logout">Log Out</a></li>
                </ul>
            </div>
        </section>
        <section class="hero-section">
            <%
                if (session == null) {
                    out.println("<p>Session is null. Please log in again.</p>");
                } else {
                    List<Notes> notes = (List<Notes>) session.getAttribute("notes");
                    if (notes != null && !notes.isEmpty()) {
            %>
            <table class="flat-table flat-table-1">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Notes</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Notes note : notes) {
                    %>
                    <tr>
                        <td id="bold-td"><%= note.getTitle() %></td>
                        <td><%= note.getNote() %></td>
                        <td id="delete-btn"><a href="Delete?note_id=<%= note.getId() %>">X</a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <%
                    } else {
            %>
            <p>No notes available.</p>
            <%
                    }
                }
            %>
        </section>
    </div>
</body>
</html>
