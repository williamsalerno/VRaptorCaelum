<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="container">
	<div class="page-header">
		<h1>Lista de produtos</h1>
	</div>
	<c:if test="${not empty nome}">
		<h3>Resultado da busca por nome: ${nome }</h3>
	</c:if>
	<div class="bs-example" data-example-id="table-within-panel">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="title-table"> Lista de produtos</span>
			</div>
			<div class="panel-body">
				<p>
				<h3>Confira a lista de todos os produtos cadastrados.</h3>
				</p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>Código</th>
						<th>Nome</th>
						<th>Descrição</th>
						<th>Preço</th>
						<th>Comprar</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${produtoList}" var="produto">
						<tr>
							<td>${produto.id }</td>
							<td>${produto.nome }</td>
							<td>${produto.descricao }</td>

							<td>${produto.preco }</td>
							<td>
								<form action="<c:url value="/carrinho"/>" method="POST">
									<input type="hidden" name="item.produto.id" value="${produto.id }">
									<input type="number" step="1" class="qtde" name="item.quantidade" value="1"/>
									<button name="comprar" class="btn btn-success" type="submit">Comprar</button>
								</form>
							</td>
							<td><a class="btn btn-primary"
								href="<c:url value="/produtos/${produto.id}"/>"><span
									class="glyphicon glyphicon glyphicon-edit" aria-hidden="true"></span>
									Editar</a></td>
							<td>
							<form action="<c:url value="/produtos/${produto.id}"/>" method="POST">
							<button class="btn btn-danger" name="_method" value="DELETE"><span
									class="glyphicon glyphicon glyphicon-trash" aria-hidden="true"></span>
									Remover</button></form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>