package br.com.loja.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.loja.modelo.Produto;

/**
 * The Class ProdutoDAO.
 */
@Component
public class ProdutoDAO {

    /** The session. */
    private final Session session;

    /**
     * Instantiates a new produto dao.
     */
    public ProdutoDAO(Session session) {
        this.session = session;
    }

    /**
     * Save product.
     *
     * @param produto the produto
     */
    public void save(Produto produto) {
        Transaction tx = this.session.beginTransaction();
        this.session.save(produto);
        tx.commit();
    }

    /**
     * Edit.
     *
     * @param id the id
     * @param value the value
     */
    public void edit(Produto produto) {
        Transaction tx = this.session.beginTransaction();
        this.session.update(produto);
        tx.commit();
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Produto produto) {
        Transaction tx = this.session.beginTransaction();
        this.session.delete(produto);
        tx.commit();
    }

    /**
     * Lista tudo.
     *
     * @return the list
     */
    @SuppressWarnings("unchecked")
    public List<Produto> listaTudo() {
        return this.session.createCriteria(Produto.class).list();
    }

    /**
     * Carrega.
     *
     * @param id the id
     * @return the produto
     */
    public Produto buscaPorId(Long id) {
        return (Produto) this.session.load(Produto.class, id);
    }

    /**
     * Busca.
     *
     * @param nome the nome
     * @return the list
     */
    @SuppressWarnings("unchecked")
    public List<Produto> busca(String nome) {
        return session.createCriteria(Produto.class).add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)).list();
    }
    
    /**
     * Todos produtos.
     *
     * @return the list
     */
    @SuppressWarnings("unchecked")
    public List<Produto> todosProdutos(){
        return (List<Produto>) session.createCriteria(Produto.class).list();
    }

    /**
     * Recarrega.
     *
     * @param produto the produto
     */
    public void recarrega(Produto produto) {
        session.refresh(produto);
    }

    /**
     * All products with limit.
     *
     * @return the list
     */
    @SuppressWarnings("unchecked")
    public List<Produto> allProductsWithLimit() {
        return (List<Produto>) session.createCriteria(Produto.class).addOrder(Order.asc("id")).list();
    }

}
