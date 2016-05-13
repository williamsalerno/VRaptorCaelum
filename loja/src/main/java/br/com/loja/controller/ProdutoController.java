package br.com.loja.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.loja.custom.annotations.Restrito;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelo.Produto;

/**
 * The Class ProdutoController.
 */
@Resource
public class ProdutoController {

    /** The dao. */
    private final ProdutoDAO dao;

    /** The result. */
    private final Result result;

    /** The validate. */
    private final Validator validator;

    /**
     * Instantiates a new produto controller.
     *
     * @param dao the dao
     */
    public ProdutoController(ProdutoDAO dao, Result result, Validator validade) {
        this.dao = dao;
        this.result = result;
        this.validator = validade;
    }

    /**
     * Formulario.
     */
    @Restrito
    @Get("/produtos/novo")
    public void formulario() {
    }
    
    /**
     * Index.
     */
    @Get("/index")
    public List<Produto> index() {
        return dao.allProductsWithLimit();
    }

    /**
     * Busca.
     *
     * @param nome the nome
     * @return the list
     */
    public List<Produto> busca(String nome) {
        result.include("nome", nome);
        return dao.busca(nome);
    }
    
    /**
     * Lista.
     *
     * @return the list
     */
    @Get("/produtos")
    public List<Produto> lista() {
        return dao.listaTudo();
    }

    /**
     * Busca json.
     *
     * @param q the q
     */
    @Get("/produtos/busca.json")
    public void buscaJson(String q) {
        result.use(Results.json()).withoutRoot().from(dao.busca(q)).exclude("id", "descricao").serialize();
    }
    
    /**
     * Adiciona.
     *
     * @param produto the produto
     */
    @Restrito
    @Post("/produtos")
    public void adiciona(Produto produto) {
        validator.validate(produto);
        validator.onErrorUsePageOf(this).formulario();
        this.dao.save(produto);
        this.result.redirectTo(this).lista();
    }

    /**
     * Edita.
     *
     * @param id the id
     * @return the produto
     */
    @Restrito
    @Get("/produtos/{id}")
    public Produto edita(Long id) {
        return dao.buscaPorId(id);
    }

    /**
     * Altera.
     *
     * @param produto the produto
     */
    @Restrito
    @Put("/produtos/{produto.id}")
    public void altera(Produto produto) {
        dao.edit(produto);
        result.redirectTo(this).lista();
    }

    /**
     * Remove.
     *
     * @param id the id
     */
    @Restrito
    @Delete("/produtos/{id}")
    public void remove(Long id) {
        Produto produto = dao.buscaPorId(id);
        dao.delete(produto);
        result.redirectTo(this).lista();
    }

}
