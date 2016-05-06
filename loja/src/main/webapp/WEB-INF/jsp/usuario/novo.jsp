<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="container">
	<div class="page-header">
		<h1>Cadastro de novo usuário</h1>
	</div>
	<form id="usuarioForm" class="new-user-form"
		action="<c:url value="/usuario"/>" method="POST">
		<fieldset class="form-group">
			<label for="exampleInputEmail1">Nome</label> <input type="text"
				class="form-control" id="nome" class="required"
				placeholder="Digite o nome do usuário" name="usuario.nome"
				value="${usuario.nome }"> <small class="text-muted">Nome
				do usuário.</small>
		</fieldset>
		<fieldset class="form-group">
			<label for="exampleInputPassword1">Login</label> <input
				type="text" class="form-control" id="login"
				placeholder="Digite o login" name="usuario.login"
				value="${usuario.login }">
		</fieldset>
		<fieldset class="form-group">
			<label for="exampleInputPassword1">Senha</label> <input
				type="password" class="form-control" id="senha"
				placeholder="Digite uma senha" name="usuario.senha"
				value="${usuario.login }">
		</fieldset>
		<fieldset class="form-group">
			<label for="exampleInputPassword1">Confirme a senha</label> <input
				type="password" class="form-control" id="confirmacao"
				placeholder="Digite a senha novamente" equalTo="#senha">
		</fieldset>
		<button type="submit" class="btn btn-primary">Cadastrar</button>
	</form>
	<script type="text/javascript">
		$('#usuarioForm').validate();
	</script>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>