package com.servlets;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Notes;
import com.entity.User;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class ShowNotes extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = null;
		Transaction tx = null;
		try {
			User currentUser = (User)request.getSession().getAttribute("user");
			SessionFactory factory = FactoryProvider.getFactory();
			session = factory.openSession();
			String hql = "FROM User WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id",currentUser.getId());
			User user = (User)query.uniqueResult();
			HttpSession httpsession = request.getSession();
			httpsession.setAttribute("notes", user.getNotes());
			response.sendRedirect("shownotes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
