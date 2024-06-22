package com.servlets;

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.entity.User;
import com.helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			SessionFactory factory = FactoryProvider.getFactory();
			Session session = factory.openSession();
			String hql = "FROM User WHERE email = :email AND password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			User user = (User)query.uniqueResult();
			HttpSession httpsession = request.getSession();
			if(user==null) {
				httpsession.setAttribute("error", "Invalid username or password");
				response.sendRedirect("loginRegister.jsp");
				System.out.println("Error");
				System.out.println(user);
			}else {
				httpsession.setAttribute("user", user);
				response.sendRedirect("addnotes.jsp");
			}			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
