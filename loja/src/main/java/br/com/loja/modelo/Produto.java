package br.com.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * The Class Produto.
 */
@Entity
public class Produto {

    /** The id. */
    @Id @GeneratedValue
    private Long id;
    
    /** The nome. */
    @NotNull (message = "O nome deve ser preenchido!")
    @Length(min = 3, message = "O nome deve conter mais de 3 caracteres!")
    private String nome;
    
    /** The descricao. */
    @NotNull (message = "A descrição deve ser preenchida!")
    @Length(max = 200, message = "A descrição deve conter no máximo 200 caracteres!")
    private String descricao;
    
    /** The preco. */
    @NotNull (message = "O preço deve ser preenchido!")
    @DecimalMin(value = "1", message = "O produto não pode ser grátis")
    private BigDecimal preco;

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
    public BigDecimal getPreco() {
        return preco;
    }

    /**
     * Sets the preco.
     *
     * @param preco the new preco
     */
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

}
