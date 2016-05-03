package br.com.loja.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

/**
 * The Class SessionMaker.
 */
@Component
public class SessionMaker implements ComponentFactory<Session> {

    /** The factory. */
    private SessionFactory factory;

    /** The session. */
    private Session session;

    /**
     * Instantiates a new session maker.
     *
     * @param factory the factory
     */
    public SessionMaker(SessionFactory factory) {
        this.factory = factory;
    }

    /**
     * Abre.
     */
    @PostConstruct
    public void abre() {
        this.session = factory.openSession();
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.caelum.vraptor.ioc.ComponentFactory#getInstance()
     */
    @Override
    public Session getInstance() {
        Session session = factory.openSession();
        return session;
    }

    /**
     * Fecha.
     */
    @PreDestroy
    public void fecha() {
        this.session.close();
    }

}
