package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Notes;
import com.entity.User;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddNotes extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = null;
        Transaction tx = null;
		try {
			HttpSession httpsession = request.getSession();
			User user = (User)httpsession.getAttribute("user");
			String title = request.getParameter("title");
			String note = request.getParameter("notes");
			
			Notes notes = new Notes(user,title,note);
			
			SessionFactory factory = FactoryProvider.getFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(notes);
            tx.commit();
            session.close();
            httpsession.setAttribute("added", "Note added successfully");
            response.sendRedirect("addnotes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
