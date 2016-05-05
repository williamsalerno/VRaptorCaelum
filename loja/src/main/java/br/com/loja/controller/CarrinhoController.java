package br.com.loja.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelo.Carrinho;
import br.com.loja.modelo.Item;

/**
 * The Class CarrinhoController.
 */
@Resource
public class CarrinhoController {

    /** The carrinho. */
    private final Carrinho carrinho;

    /** The dao. */
    private final ProdutoDAO dao;

    /** The result. */
    private final Result result;

    /**
     * Instantiates a new carrinho controller.
     *
     * @param carrinho the carrinho
     * @param dao the dao
     * @param result the result
     */
    public CarrinhoController(Carrinho carrinho, ProdutoDAO dao, Result result) {
        this.carrinho = carrinho;
        this.dao = dao;
        this.result = result;
    }

    /**
     * Visualiza.
     */
    @Get("/carrinho")
    public void visualiza() {
    }

    /**
     * Adiciona.
     *
     * @param item the item
     */
    @Post("/carrinho")
    public void adiciona(Item item) {
        dao.recarrega(item.getProduto());
        carrinho.adiciona(item);

        result.redirectTo(this).visualiza();
    }
    
    /**
     * Remove.
     *
     * @param indiceItem the indice item
     */
    @Delete("/carrinho/{indiceItem}")
    public void remove(int indiceItem) {
      carrinho.remove(indiceItem);
      result.redirectTo(this).visualiza();
    }
}
