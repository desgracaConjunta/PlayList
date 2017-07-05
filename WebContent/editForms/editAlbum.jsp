<%@page import="java.util.ArrayList"%>
<%@page import="model.Album"%>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">Adicionar Album</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-8">
			<form method="post" action="Handler">
				<div id="form1">
					<div class="form-group">
						<label>Nome do Album a Editar:</label> <select
							class="form-control" name="listaAlbum" id="listaAlbum"
							onchange="edit(this)">
							<option value="">Seleciona um Album</option>
							<%
								ArrayList Album = (ArrayList) request.getAttribute("listaAlbuns");
								for (int i = 0; i < Album.size(); i++) {
									Album alb = (Album) Album.get(i);
									out.append("<option value='" + i + "'>" + alb.getAlbum_nome() + "</option>");
								}
							%>
						</select>
					</div>
				</div>
				<div id="formAlb" style="Display: none;">
					<div class="form-group">
						<label>Nome do Album</label>
						<input type="text" class="form-control" name="editAlbum" id="editAlbum">
					</div>
					<div class="text-right">
						<div class="form-group">
							<input type="hidden" name="logica" value="SAlbum">
							<input type="hidden" name="acao"   value="editT">
							<input type="button" class="btn btn-danger" value="Cancelar"
								name="cancelar"
								onclick="location.href = 'Handler?pag=album&b=edit';"> <input
								class="btn btn-sucess" type="submit" value="Editar" name="editar">
						</div>	
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
	function edit(field){
		if(field.value != ''){
			window.location = "Handler?pag=album&b=edit&id=" + field.value;	
		}
	}
	$( document ).ready(function(){
		<% if(request.getParameter("id") != null){
			Album alb = (Album) Album.get(Integer.parseInt(request.getParameter("id")));%>
			$("#formAlb").css("display","block");
			//System.out.println(Integer.parseInt(req.getParameter("listaAlbum")));
		<% out.append("$('#editAlbum').attr('value','" + alb.getAlbum_nome() + "');");
		   out.append("$('#listaAlbum').attr('value','" + request.getParameter("id") + "');");	
		   out.append("\n$('#listaAlbum').val(" + request.getParameter("id") + ");");
		}%>

	});

</script>

