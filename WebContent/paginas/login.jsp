<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
				<h1 class="page-header">Login</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<form method="POST" action="Handler">
				<div class="form-group">
					<input type="email" class="form-control" name="user_login_email" id="user_login_email" placeholder="E-mail">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="user_login_pass" id="user_login_pass" placeholder="Password">
				</div>
				<div class="text-right">
					<div class="form-group">
						<input type="hidden" name="logica" value="SUser"> 
						<input type="hidden" name="acao" value="login"> 
						<input class="btn btn-primary" type="submit" value="Entrar" name="entrar">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>