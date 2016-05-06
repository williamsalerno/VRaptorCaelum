<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="container">
	<div class="page-header">
		<h1>Itens do seu carrinho de compras</h1>
	</div>

	<c:if test="${empty carrinho or carrinho.totalDeItens eq 0 }">
		<div class="alert alert-info">
			<strong>Não há itens no seu carrinho de compras!</strong>
		</div>
	</c:if>
	<c:if test="${carrinho.totalDeItens > 0 }">
		<div class="bs-example" data-example-id="table-within-panel">
			<div class="panel panel-default">
				<div class="panel-heading">Carrinho de compras</div>
				<div class="panel-body">
					<p>Lista de produtos dentro do carrinho de compras.</p>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Descrição</th>
							<th>Preço</th>
							<th>Qtde</th>
							<th>Total</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${carrinho.itens}" var="item" varStatus="s">
							<tr>
								<td>${item.produto.nome }</td>
								<td>${item.produto.descricao }</td>
								<td><fmt:formatNumber type="currency"
										value="${item.produto.preco }" /></td>
								<td>${item.quantidade }</td>
								<td><fmt:formatNumber type="currency"
										value="${item.quantidade * item.produto.preco }" /></td>
								<td>
									<form action="<c:url value="/carrinho/${s.index}"/>"
										method="POST">
										<button class="link btn btn-danger" name="_method" value="DELETE">Remover  <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
									</form>
								</td>
								<td></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="finalizar-compra-voltar">
				<a href="produtos" class="btn btn-default">Voltar</a>
				<a href="#" class="btn btn-success">Finalizar compra</a>
			</div>
		</div>
	</c:if>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>