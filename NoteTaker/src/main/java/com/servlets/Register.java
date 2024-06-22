package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.entity.User;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Register extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Session session = null;
        Transaction tx = null;
    	try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = new User(name, email, password);

            SessionFactory factory = FactoryProvider.getFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            session.close();
            HttpSession httpsession = request.getSession();
            httpsession.setAttribute("success", "Registration successfully");
            response.sendRedirect("loginRegister.jsp");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
