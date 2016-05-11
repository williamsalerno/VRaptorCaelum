<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="container">
	<div class="container">
		<div class="page-header">
			<h1>
				Adicionar um produto <small>preencha todos os campos!</small>
			</h1>
		</div>
	</div>
	<form id="produtosForm" class="forms-alter"
		action="<c:url value="/produtos/${produto.id }"/>" method="POST">
		<fieldset class="form-group">
			<label for="nome">Nome do produto</label> <input type="text"
				class="form-control" id="nome" name="produto.nome"
				placeholder="Digite o nome do produto" value="${produto.nome }">
			<small class="text-muted">Campo obrigatório</small>
		</fieldset>
		<!-- <fieldset class="form-group">
		    <label for="exampleInputPassword1"></label>
		    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
		  </fieldset> -->
		<!-- <fieldset class="form-group">
		    <label for="exampleSelect1">Example select</label>
		    <select class="form-control" id="exampleSelect1">
		      <option>1</option>
		      <option>2</option>
		      <option>3</option>
		      <option>4</option>
		      <option>5</option>
		    </select>
		  </fieldset> -->
		<!--<fieldset class="form-group">
		    <label for="exampleSelect2">Example multiple select</label>
		    <select multiple class="form-control" id="exampleSelect2">
		      <option>1</option>
		      <option>2</option>
		      <option>3</option>
		      <option>4</option>
		      <option>5</option>
		    </select>
		  </fieldset> -->
		<fieldset class="form-group">
			<label for="preco">Preço do produto</label> <input type="number"
				step="0.10" class="form-control" id="preco" name="produto.preco"
				placeholder="Digite o Preço do produto" value="${produto.preco }">
			<small class="text-muted">Campo obrigatório</small>
		</fieldset>
		<fieldset class="form-group">
			<label for="descricao">Descrição do produto</label>
			<textarea class="form-control" id="descricao"
				name="produto.descricao" rows="3">${produto.descricao }</textarea>
			<small class="text-muted">Campo obrigatório</small>
		</fieldset>
		<!-- <div class="radio">
		    <label>
		      <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
		      Option one is this and that&mdash;be sure to include why it's great
		    </label>
		  </div>  -->
		<!--<div class="radio">
		    <label>
		      <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
		      Option two can be something else and selecting it will deselect option one
		    </label>
		  </div> -->
		<!--<div class="radio disabled">
		    <label>
		      <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3" disabled>
		      Option three is disabled
		    </label>
		  </div>-->
		<!--<div class="checkbox">
		    <label>
		      <input type="checkbox"> Check me out
		    </label>
		  </div>-->
		<button type="submit" class="btn btn-primary" name="_method"
			value="PUT">
			<span class="glyphicon glyphicon glyphicon-floppy-save"
				aria-hidden="true"></span> Salvar alterações
		</button>
	</form>
	<br /> <br />
	<form class="forms-alter"
		action="<c:url value="/produtos/${produto.id }/imagem"/> "
		method="POST" enctype="multipart/form-data">
		<h3>Adicionar uma imagem para o produto</h3>
		<br/>
		<img class="product-thumbnail" src="<c:url value="/produtos/${produto.id }/imagem"/>" width="70" height="100" />
		<fieldset class="form-group">
			<label for="exampleInputFile">Imagem do produto</label> <input
				type="file" class="form-control-file" name="imagem" id="exampleInputFile">
			<small class="text-muted">Carregar imagem do produto: GIF,
				JPG ou PNG.</small> <br />
			<br />
			<button type="submit" class="btn btn-primary">
				<span class="glyphicon glyphicon glyphicon-floppy-save"
					aria-hidden="true"></span> Salvar imagem
			</button>
		</fieldset>
	</form>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>