package br.com.loja.interceptors;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.loja.controller.UsuarioController;
import br.com.loja.controller.UsuarioWeb;
import br.com.loja.custom.annotations.Restrito;

/**
 * The Class AutenticacaoInterceptor.
 */
@Intercepts
public class AutenticacaoInterceptor implements Interceptor {

    /** The usuario. */
    private final UsuarioWeb usuario;
    
    /** The result. */
    private final Result result;

    /**
     * Instantiates a new autenticacao interceptor.
     *
     * @param usuario the usuario
     * @param result the result
     */
    public AutenticacaoInterceptor(UsuarioWeb usuario, Result result) {
        this.usuario = usuario;
        this.result = result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.caelum.vraptor.interceptor.Interceptor#intercept(br.com.caelum.vraptor.core.InterceptorStack, br.com.caelum.vraptor.resource.ResourceMethod, java.lang.Object)
     */
    @Override
    public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {
        result.redirectTo(UsuarioController.class).loginForm();

    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.caelum.vraptor.interceptor.Interceptor#accepts(br.com.caelum.vraptor.resource.ResourceMethod)
     */
    @Override
    public boolean accepts(ResourceMethod method) {
        return !usuario.isLogado() && method.containsAnnotation(Restrito.class);
    }

}
