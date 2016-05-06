package br.com.loja.modelo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * The Class Carrinho.
 */
@Component
@SessionScoped
public class Carrinho {

    /** The itens. */
    private List<Item> itens = new ArrayList<Item>();

    /** The total. */
    private BigDecimal total = new BigDecimal("0.0");

    /** The total itens. */
    private BigInteger totalItens = new BigInteger("0");

    /**
     * Gets the itens.
     *
     * @return the itens
     */
    public List<Item> getItens() {
        return itens;
    }

    /**
     * Sets the itens.
     *
     * @param itens the new itens
     */
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    /**
     * Gets the total.
     *
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Sets the total.
     *
     * @param total the new total
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * Adiciona.
     *
     * @param item the item
     */
    public void adiciona(Item item) {
        this.itens.add(item);
        this.total = item.getProduto().getPreco().multiply(new BigDecimal(item.getQuantidade())).add(this.total);
        this.totalItens = this.totalItens.add(new BigInteger(item.getQuantidade()));
    }

    /**
     * Gets the total de itens.
     *
     * @return the total de itens
     */
    public BigInteger getTotalDeItens() {
        return this.totalItens;
    }

    /**
     * Remove.
     *
     * @param indiceItem the indice item
     */
    public void remove(int indiceItem) {
        Item removido = itens.remove(indiceItem);
        this.total = this.total.subtract(new BigDecimal(removido.getQuantidade()).multiply(removido.getProduto().getPreco()));
        this.totalItens = this.totalItens.subtract(new BigInteger(removido.getQuantidade()));
    }
}
