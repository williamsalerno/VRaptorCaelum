package br.com.loja.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

// TODO: Auto-generated Javadoc
/**
 * The Class Carrinho.
 */
@Component
@SessionScoped
public class Carrinho {

    /** The itens. */
    private List<Item> itens = new ArrayList<Item>();

    /** The total. */
    private Double total = 0.0;

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
    public Double getTotal() {
        return total;
    }

    /**
     * Sets the total.
     *
     * @param total the new total
     */
    public void setTotal(Double total) {
        this.total = total;
    }
    
    /**
     * Adiciona.
     *
     * @param item the item
     */
    public void adiciona(Item item) {
        this.itens.add(item);
        this.total += item.getProduto().getPreco() * item.getQuantidade();
    }

    /**
     * Gets the total de itens.
     *
     * @return the total de itens
     */
    public Integer getTotalDeItens() {
        return this.itens.size();
    }
    
    /**
     * Remove.
     *
     * @param indiceItem the indice item
     */
    public void remove(int indiceItem) {
        Item removido = itens.remove(indiceItem);
        total -= removido.getProduto().getPreco() * removido.getQuantidade();
    }
}
