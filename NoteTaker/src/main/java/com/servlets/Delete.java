package com.servlets;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Notes;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = null;
        Transaction tx = null;
        try {
            String noteIdParam = request.getParameter("note_id");
            if (noteIdParam == null || noteIdParam.trim().isEmpty()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid or missing note ID.");
                return;
            }

            int id = Integer.parseInt(noteIdParam.trim());
            System.out.println("Deleting note with ID: " + id);

            SessionFactory factory = FactoryProvider.getFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            Notes note = session.get(Notes.class, id);
            if (note == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Note not found.");
                return;
            }

            session.delete(note);
            tx.commit();
            session.close();

            // Refresh the notes list
            session = factory.openSession();
            List<Notes> notes = session.createQuery("from Notes", Notes.class).list();
            request.getSession().setAttribute("notes", notes);
            session.close();

            response.sendRedirect("shownotes.jsp");

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid note ID format.");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while deleting the note.");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
