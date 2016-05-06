<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="container">
	<div class="page-header">
		<h1>Entrar no sistema</h1>
	</div>
	<form id="usuarioForm" class="new-user-form"
		action="<c:url value="/login"/>" method="POST">
		<fieldset class="form-group">
			<label for="exampleInputPassword1">Login</label> <input
				type="text" class="form-control" id="login"
				placeholder="Digite o login" name="usuario.login">
		</fieldset>
		<fieldset class="form-group">
			<label for="exampleInputPassword1">Senha</label> <input
				type="password" class="form-control" id="senha"
				placeholder="Digite uma senha" name="usuario.senha">
		</fieldset>
		<button type="submit" class="btn btn-primary">Logar</button>
	</form>
	<script type="text/javascript">
		$('#usuarioForm').validate();
	</script>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>