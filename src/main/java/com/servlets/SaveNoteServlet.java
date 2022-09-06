package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import com.entities.Note;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveNoteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String title = request.getParameter("note_title");
			String description = request.getParameter("note_desc");
			PrintWriter out=response.getWriter();
			
			
			Note note = new Note(title, description, new Date());

			
			
			// System.out.println(note.getId() + " " + note.getTitle() + " " +
			// note.getContent());

			// Saving Data using Hibernate

			Session session = FactoryProvider.getFactory().openSession();
			Transaction txTransaction = session.beginTransaction();
			session.persist(note);
			txTransaction.commit();
			session.close();
			response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
