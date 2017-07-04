<%@page import="java.util.ArrayList"%>
<%@page import="model.Album"%>
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Eliminar Album</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<form method="post" action="Handler">
					<div class="form-group">
						<label>Album a Eliminar:</label>
							<select class="form-control" name="listaAlb" id="listaAlb" onchange="verif(this)">
								<option value="s">Seleciona um tipo</option>
								<%
								ArrayList arAlb = (ArrayList) request.getAttribute("listaAlbuns");

								for (int i = 0; i < arAlb.size(); i++) {
									Album alb = (Album) arAlb.get(i);
									out.append("<option value='" + i + "'>" + alb.getAlbum_nome() + "</option>");
								}
							%>
						</select>
					</div>
					<div class="text-right">
						<div class="form-group">
							<input type="hidden" name="logica" value="SAlbum"> 
							<input type="hidden" name="acao" value="delAlbum">
							<button type="button" class="btn btn-danger" data-toggle="modal" id="confElim" data-target="#confirm">Eliminar</button>
						</div>
					</div>

					<div class="modal fade" id="confirm" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Confirmação</h4>
								</div>
								<div class="modal-body">
									<p id="alb"></p>
								</div>
								<div class="modal-footer">
									<input class="btn btn-danger" type="submit" value="Eliminar" name="eliminar">
									<button type="button" class="btn btn-default" onclick="location.href = 'Handler?pag=album&b=elim';" data-dismiss="modal">Cancelar</button>
								</div>
							</div>
						</div>
					</div>
			</form>
		</div>
	</div>
</div>

<script>
	$(document).ready(
			function() {
				if ($("#listaAlb").val() != "s") {
					$("#confElim").attr("disabled", "true");
				} else {
					$("#confElim").removeAttr("disabled", "false");
					$("#alb").append(
							"Tem a certeza que deseja eliminar o album? "
									+ field.text());
				}
			});

	function verif(field) {
		if ($("#listaAlb").val() == "s") {
			$("#confElim").attr("disabled", "true");
		} else {
			$("#confElim").removeAttr("disabled", "false");
			$("#alb").append(
					"Tem a certeza que deseja eliminar o album <b>"
							+ $("#listaAlb option:selected").html() + "</b>");
		}
	}
</script>