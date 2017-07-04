<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1 class="page-header">Login</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Entrar</h3>
				</div>
				<div class="panel-body">
					<form role="form" method="post">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="E-mail" name="user"
									type="email" autofocus required>
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password" name="pass"
									type="password" value="" required>
							</div>
							<div class="form-group">
								<input type="hidden" name="logica" value="SLogin"> <input
									type="hidden" name="acao" value="login"> <input
									type="submit" name="login" value="entrar" class="form-control">
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="row" id="erro" style="display: none;">
		<div class="col-md-4 col-md-offset-4">
			<div class="alert alert-danger">Credenciais erradas!</div>
		</div>
	</div>
</div>

<script>
	$( document ).ready(function() {
	   <% if(session.getAttribute("log") == "0"){ %>
		   $("#erro").css("display","block");
	   <% }else{ %>
	  	 $("#erro").css("display","none");
	   <% } %>
	});
</script>