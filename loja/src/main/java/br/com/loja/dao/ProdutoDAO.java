package br.com.loja.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
