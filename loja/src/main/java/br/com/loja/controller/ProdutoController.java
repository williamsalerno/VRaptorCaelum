package br.com.loja.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
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
    private final Validator validate;

    /**
     * Instantiates a new produto controller.
     *
     * @param dao the dao
     */
    public ProdutoController(ProdutoDAO dao, Result result, Validator validade) {
        this.dao = dao;
        this.result = result;
        this.validate = validade;
    }

    /**
     * Formulario.
     */
    public void formulario() {
    }

    /**
     * Lista.
     *
     * @return the list
     */
    public List<Produto> lista() {
        return dao.listaTudo();
    }

    /**
     * Adiciona.
     *
     * @param produto the produto
     */
    public void adiciona(Produto produto) {
        if (produto.getNome() == null || produto.getNome().length() < 3) {
            validate.add(new ValidationMessage("Nome é obrigatório e precisa ter mais" + " de 3 letras", "produto.nome"));
        }
        if (produto.getDescricao() == null || produto.getDescricao().length() > 40) {
            validate.add(new ValidationMessage("Descrição é obrigatória não pode ter mais" + " que 40 letras", "produto.descricao"));
        }
        if (produto.getPreco() <= 0) {
            validate.add(new ValidationMessage("Preço precisa ser positivo", "produto.preco"));
        }
        validate.onErrorUsePageOf(this).formulario();
        this.dao.save(produto);
        this.result.redirectTo(this).lista();
    }

    /**
     * Edita.
     *
     * @param id the id
     * @return the produto
     */
    public Produto edita(Long id) {
        return dao.buscaPorId(id);
    }

    /**
     * Altera.
     *
     * @param produto the produto
     */
    public void altera(Produto produto) {
        dao.edit(produto);
        result.redirectTo(this).lista();
    }

    /**
     * Remove.
     *
     * @param id the id
     */
    public void remove(Long id) {
        Produto produto = dao.buscaPorId(id);
        dao.delete(produto);
        result.redirectTo(this).lista();
    }

}
