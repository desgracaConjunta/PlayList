<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, model.Album"%>

<div class="container-fluid">
	<ul class="nav nav-pills">
		<li role="presentation" class="active"><a
			href="Handler?pag=album">Album</a></li>
		<li role="presentation"><a href="Handler?pag=album&b=add">Adicionar
				Album</a></li>
		<li role="presentation"><a href="Handler?pag=album&b=edit">Editar
				Album</a></li>
		<li role="presentation"><a href="Handler?pag=album&b=elim">Eliminar
				Album</a></li>
	</ul>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Album</h1>
		</div>
	</div>
	<%
		if (request.getParameter("b") != null) {
			if (request.getParameter("b").equals("add")) {
	%>
	<jsp:include page="../addForms/addAlbum.jsp" />
	<%
		} else if (request.getParameter("b").equals("edit")) {
	%>
	<jsp:include page="../editForms/editAlbum.jsp" />
	<%
		} else {
	%>
	<jsp:include page="../delForms/delAlbum.jsp" />
	<%
		}
		} else {
	%>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th>Numero do Album</th>
						<th>Nome do Album</th>
						<th>Estado do Album</th>
					</tr>
				</thead>
				<tbody>
					<%
						if (request.getAttribute("listaAlbuns") != null) {
								ArrayList arAlbuns = (ArrayList) request.getAttribute("listaAlbuns");
								for (int i = 0; i < arAlbuns.size(); i++) {
									Album user = (Album) arAlbuns.get(i);
									out.append("<tr><td>" + user.getAlbum_id() + "</td><td>" + user.getAlbum_nome() + "</td><td>"
											+ user.getAlbum_enabled() + "</td></tr>");

								}
							}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<%
		}
	%>
</div>
