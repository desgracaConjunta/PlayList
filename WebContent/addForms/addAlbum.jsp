<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">Adicionar Album</h3>
		</div>
	</div>
	<div class="row">
		<div class="container">
			<div class="col-lg-8">
				<form method="post" action="Handler">
					<div class="form-group">
						<label>Nome do Album:</label> 
						<input type="text" class="form-control" id="add_nome_album" name="add_nome_album" placeholder="Nome do Album">
					</div>
					<div class="form-group">
						<input type="hidden" name="logica" id="logica" value="SAlbum">
						<input type="hidden" name="acao" id="acao" value="addAlbum">
						<input type="submit" class="btn btn-success" value="Registar" name="reg_album" id="reg_album">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>