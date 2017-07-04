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
				<div id="form2" style="display: none">
					<div class="form-group">
						<label>Nome do Album</label>
						<input type="text" class="form-control" name="edit_Album" id="edit_Album">
					</div>
				</div>
				<div class="text-right">
					<div class="form-group">
						<input type="hidden" name="logica" id="logica" value="SAlbum">
						<input type="hidden" name="acao" id="acao" value="editAlbum">
						<input type="button" class="btn btn-danger" value="Cancelar"
							name="cancelar"
							onclick="location.href = 'Handler?pag=album&b=edit';"> <input
							class="btn btn-sucess" type="submit" value="Editar" name="editar">

					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<<script type="text/javascript">
	function edit(field){
		window.location = "Handler?pag=album&b=";
	}

</script>





























<div id="form1">
	<div class="form-group">
		<label>Tema a editar:</label> <select class="form-control"
			name="listaTemas" id="listaTemas" onchange="edit(this)">
			<option value="sem">Sem precedência</option>
			<%
				ArrayList temas = (ArrayList) request.getAttribute("arrayTemas");

				for (int i = 0; i < temas.size(); i++) {
					Tema tema = (Tema) temas.get(i);
					out.append("<option value='" + i + "'>" + tema.getNomeTema() + "</option>");
				}
			%>
		</select>
	</div>
</div>