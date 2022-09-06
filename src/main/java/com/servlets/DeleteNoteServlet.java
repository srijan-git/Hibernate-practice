package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DeleteNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteNoteServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());
			out.print(noteId);
			
			Session session=FactoryProvider.getFactory().openSession();
			Note note=(Note)session.get(Note.class, noteId);
			Transaction txTransaction=session.beginTransaction();
			session.delete(note);
			txTransaction.commit();
			session.close();
			response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
