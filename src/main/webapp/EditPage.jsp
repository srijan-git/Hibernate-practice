<%@page import="com.entities.Note"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Note: NoteBook</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container-fuild">
		<%@include file="navbar.jsp"%>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-sm-3">
				<h1 class="mt-2">Please update your details</h1>

				<%
				int noteId = Integer.parseInt(request.getParameter("note_id"));
				Session s = FactoryProvider.getFactory().openSession();
				Note note = (Note) s.get(Note.class, noteId);
				%>



				<!-- Forms -->
				<form action="UpdateServlet" method="POST">
					<div class="form-group">
						<input type="hidden" name="note_id" class="form-control"
							id="note_title" value="<%=note.getId()%>"
							aria-describedby="emailHelp"  /> 
							
							
							
							<label for="note_title">Note
							title</label> <input type="text" name="note_title" class="form-control"
							id="note_title" value="<%=note.getTitle()%>"
							aria-describedby="emailHelp" required />
					</div>
					<div class="form-group">
						<label for="note_desc">Description</label>
						<textarea rows="7" class="form-control" id="note_desc"
							name="note_desc" style="resize: none;" required><%=note.getContent()%></textarea>
					</div>

					<div class="container text-center">
						<button type="submit" class="btn btn-success">Update</button>
					</div>

				</form>
			</div>
		</div>
	</div>





	<!-- Option 2: Separate Popper and Bootstrap JS -->

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
		integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
		crossorigin="anonymous"></script>
</body>
</html>