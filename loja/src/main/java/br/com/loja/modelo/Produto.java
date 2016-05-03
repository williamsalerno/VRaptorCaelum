package br.com.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class Produto.
 */
@Entity
public class Produto {

    /** The id. */
    @Id @GeneratedValue
    private Long id;
    
    /** The nome. */
    private String nome;
    
    /** The descricao. */
    private String descricao;
    
    /** The preco. */
    private Double preco;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets the descricao.
     *
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Sets the descricao.
     *
     * @param descricao the new descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Gets the preco.
     *
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * Sets the preco.
     *
     * @param preco the new preco
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
