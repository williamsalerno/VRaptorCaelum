package br.com.loja.modelo;

/**
 * The Class Item.
 */
public class Item {

    /** The produto. */
    private Produto produto;

    /** The quantidade. */
    private String quantidade;

    /**
     * Gets the produto.
     *
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Sets the produto.
     *
     * @param produto the new produto
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Gets the quantidade.
     *
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * Sets the quantidade.
     *
     * @param quantidade the new quantidade
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

}
