package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String title = request.getParameter("note_title");
			String description = request.getParameter("note_desc");
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());
			
			Session sessionFactory = FactoryProvider.getFactory().openSession();
			Transaction txTransaction = sessionFactory.beginTransaction();
			Note note=sessionFactory.get(Note.class,noteId);
			
			note.setTitle(title);
			note.setContent(description);
			note.setAddedDate(new Date());

			txTransaction.commit();
			sessionFactory.close();
			
			response.sendRedirect("all_notes.jsp");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
