<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<h3 class="page-header">Adicionar Musica</h3>
		</div>
	</div>
	<div class="row">
		<div class="container">
			<div class="col-lg-8">
				<form method="post" action="Handler">
					<div class="form-group">
						<label>Titulo da Musica:</label> 
						<input type="text" class="form-control" name="add_musica_nome" placeholder="Nome Musica">
					</div>
					<div class="form-group">
						<label>Localização:</label>
						<input type="file" class="form-control" name="add_musica_path" accept="audio/*">
					</div>
					<div class="form-group">
						<label></label>
						  <input type="text" class="form-control">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>