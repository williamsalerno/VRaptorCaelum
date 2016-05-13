<%@ include file="/WEB-INF/jspf/header.jspf"%>
<%@ include file="/WEB-INF/jspf/slider.jspf"%>
<section id="produtos">
	<div class="container">
		<div class="product-title">
			<h1>
				The products <br> <small>Check our product list, know
					more and buy one!</small>
			</h1>
		</div>
		<section id="produtos-section">
			<div id="produtos-row" class="produtos-row tab-content">
				<c:forEach items="${produtoList }" var="produto">
					<div id="produto${produto.id}"
						class="thumbnail thumbs hvr-radial-out">
						<img src="<c:url value="/produtos/${produto.id }/imagem"/>"
							data-holder-rendered="true"
							style="height: 200px; width: 100%; display: block;">
						<div class="caption">
							<h3>${produto.nome }<small class="codigo-produto"> <span>cod:</span>${produto.id }</small>
							</h3>
							<p class="descricao-produto">${produto.descricao }</p>
							<p class="valor-produto">
								<span>R$</span>${produto.preco }</p>
							<div>
								<c:if test="${usuarioWeb.logado }">
									<a style="margin: 0 5px;"
										href="<c:url value="/produtos/${produto.id }"/>"
										name="comprar" class="btn btn-default">Editar  <span
										class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
								</c:if>
								<form style="float: left;" action="<c:url value="/carrinho"/>"
									method="POST">
									<input type="hidden" name="item.produto.id"
										value="${produto.id }"> <input type="hidden"
										class="qtde" name="item.quantidade" value="1" />
									<button name="comprar" class="btn btn-success" type="submit">Comprar</button>
								</form>
							</div>

						</div>
					</div>
				</c:forEach>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</section>
		<script type="text/javascript">
			$('.thumbs').mouseenter(function() {
				$('.valor-produto', this).stop().css({
					"color" : "#032905",
					"transition" : "100ms all ease"
				});
			});
			$('.thumbs').mouseleave(function() {
				$('.valor-produto', this).stop().css({
					"color" : "#44B749",
					"transition" : "100ms all ease"
				});
			});

			$('.thumbs').mouseenter(function() {
				$('.caption', this).animate({
					marginTop : '-87%'
				}, 500)
			});
			$('.thumbs').mouseleave(function() {
				$('.caption', this).animate({
					marginTop : '0'
				}, 500)
			});
		</script>
	</div>
</section>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>