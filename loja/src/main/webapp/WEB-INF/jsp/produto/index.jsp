<%@ include file="/WEB-INF/jspf/header.jspf"%>
<%@ include file="/WEB-INF/jspf/slider.jspf"%>
<div class="container">
	<section id="produtos-section">
		<c:forEach items="${produtoList }" var="produto">
			<div class="thumbnail thumbs hvr-radial-out">
				<img src="<c:url value="/produtos/${produto.id }/imagem"/>"
					data-holder-rendered="true"
					style="height: 200px; width: 100%; display: block;">
				<div class="caption">
					<h3>${produto.nome }<small class="codigo-produto">  <span>cod:</span>${produto.id }</small></h3>
					<p class="descricao-produto">${produto.descricao }</p>
					<p class="valor-produto">
						<span>R$</span>${produto.preco }</p>
					<div>
						<form action="<c:url value="/carrinho"/>" method="POST">
							<input type="hidden" name="item.produto.id"
								value="${produto.id }">
							<input type="hidden" class="qtde" name="item.quantidade" value="1"/>
							<button name="comprar" class="btn btn-success" type="submit">Comprar</button>
						</form>
					</div>

				</div>
			</div>
		</c:forEach>
	</section>
	<script type="text/javascript">
		$('.thumbs').mouseenter(function() {
			$('.valor-produto', this).stop().css({"color":"#032905", "transition": "100ms all ease"});
			$('.codigo-produto', this).stop().css({"color": "#FFFFFF", "transition": "100ms all ease"});
		});
		$('.thumbs').mouseleave(function() {
			$('.valor-produto', this).stop().css({"color":"#44B749", "transition": "100ms all ease"});
			$('.codigo-produto', this).stop().css({"color": "#777", "transition": "100ms all ease"});
		});
	</script>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>