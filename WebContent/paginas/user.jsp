<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, model.User"%>

<div class="container-fluid">
	<ul class="nav nav-pills">
		<li role="presentation" class="active"><a href="Handler?pag=u">Users</a></li>
		<li role="presentation"><a href="Handler?pag=users&u=add">Adicionar
				User</a></li>
		<li role="presentation"><a href="Handler?pag=users&u=edit">Editar
				User</a></li>
		<li role="presentation"><a href="Handler?pag=users&u=elim">Eliminar
				User</a></li>
	</ul>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Users</h1>
		</div>
	</div>
	<%
	if (request.getParameter("u") != null) {
		if (request.getParameter("u").equals("add")) {
			%>
	<jsp:include page="../addForms/addUser.jsp" />
	<%
		} else if (request.getParameter("u").equals("edit")) {
			%>
	<jsp:include page="../editForms/editUser.jsp" />
	<%
		}else{
			%>
	<jsp:include page="../delForms/delUser.jsp" />
	<% 
		}
		}else{
	%>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered table-hover table-striped">
				<thead>
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
            if(request.getAttribute("listaUsers")!=null){
            	 ArrayList arU = (ArrayList)request.getAttribute("listaUsers");
            	 
     			for(int i=0;i<arU.size();i++){
     				User user = (User)arU.get(i);
     				out.append("<tr><td></td><td></td><td>"); 
     							
    
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

