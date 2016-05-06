package br.com.loja.dao;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.loja.modelo.Usuario;

/**
 * The Class UsuarioDAO.
 */
@Component
public class UsuarioDAO {

    /** The session. */
    private final Session session;

    /**
     * Instantiates a new usuario dao.
     *
     * @param session the session
     */
    public UsuarioDAO(Session session) {
        this.session = session;
    }

    /**
     * Existe usuario.
     *
     * @param usuario the usuario
     * @return true, if successful
     */
    public boolean existeUsuario(Usuario usuario) {
        Usuario encontrado = (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("login", usuario.getLogin())).uniqueResult();
        return encontrado != null;
    }
    
    /**
     * Adiciona.
     *
     * @param usuario the usuario
     */
    public void adiciona(Usuario usuario) {
        Transaction tx = this.session.beginTransaction();
        this.session.save(usuario);
        tx.commit();
    }

    /**
     * Carrega.
     *
     * @param usuario the usuario
     * @return the usuario
     */
    public Usuario carrega(Usuario usuario) {
        return (Usuario) session.createCriteria(Usuario.class)
                .add(Restrictions.eq("login", usuario.getLogin()))
                .add(Restrictions.eq("senha", usuario.getSenha()))
                .uniqueResult();
    }
}
