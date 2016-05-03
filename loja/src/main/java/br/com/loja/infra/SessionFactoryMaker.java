package br.com.loja.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

/**
 * The Class SessionFactoryMaker.
 */
@SuppressWarnings("deprecation")
@Component
@ApplicationScoped
public class SessionFactoryMaker implements ComponentFactory<SessionFactory> {

    /** The factory. */
    private SessionFactory factory;

    /**
     * Abre.
     */
    @PostConstruct
    public void abre() {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure();

        this.factory = configuration.buildSessionFactory();
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.caelum.vraptor.ioc.ComponentFactory#getInstance()
     */
    @Override
    public SessionFactory getInstance() {
        return this.factory;
    }

    /**
     * Fecha.
     */
    @PreDestroy
    public void fecha() {
        this.factory.close();
    }
}
