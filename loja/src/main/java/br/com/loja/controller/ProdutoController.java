package br.com.loja.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
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
    @Get("/produtos/novo")
    public void formulario() {
    }
    
    /**
     * Index.
     */
    @Get("/index")
    public void index() {
        
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
     * Adiciona.
     *
     * @param produto the produto
     */
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
    @Get("/produtos/{id}")
    public Produto edita(Long id) {
        return dao.buscaPorId(id);
    }

    /**
     * Altera.
     *
     * @param produto the produto
     */
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
    @Delete("/produtos/{id}")
    public void remove(Long id) {
        Produto produto = dao.buscaPorId(id);
        dao.delete(produto);
        result.redirectTo(this).lista();
    }

}
