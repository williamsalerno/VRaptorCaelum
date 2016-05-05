<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="container">
	<div class="page-header">
		<h1>
			Adicionar um produto <small>preencha todos os campos!</small>
		</h1>
	</div>
</div>
<div class="container">
	<div id="erros" class="errors">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li><div class="alert alert-danger" role="alert">
						<span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span><strong>${error.category }</strong>
						- ${error.message }
					</div></li>
			</c:forEach>
		</ul>
	</div>
	<form id="produtosForm" class="forms-adc" action="<c:url value="/produtos"/>" method="POST">
		<fieldset class="form-group">
			<label for="nome">Nome do produto</label> <input type="text"
				class="form-control" id="nome" name="produto.nome"
				placeholder="Digite o nome do produto" minlength="3" value="${produto.nome }">
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
				placeholder="Digite o Preço do produto" min="0" value="${produto.preco }">
			<small class="text-muted">Campo obrigatório</small>
		</fieldset>
		<fieldset class="form-group">
			<label for="descricao">Descrição do produto</label>
			<textarea class="form-control" id="descricao"
				name="produto.descricao" maxlength="40" rows="3">${produto.descricao }</textarea>
			<small class="text-muted">Campo obrigatório</small>
		</fieldset>
		<!-- <fieldset class="form-group">
		    <label for="exampleInputFile">File input</label>
		    <input type="file" class="form-control-file" id="exampleInputFile">
		    <small class="text-muted">This is some placeholder block-level help text for the above input. It's a bit lighter and easily wraps to a new line.</small>
		  </fieldset>  -->
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
		<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon glyphicon glyphicon-floppy-save" aria-hidden="true"></span>  Adicionar
			produto</button>
	</form>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
