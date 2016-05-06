package br.com.loja.controller;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.loja.modelo.Usuario;

/**
 * The Class UsuarioWeb.
 */
@Component
@SessionScoped
public class UsuarioWeb {

    /** The logado. */
    private Usuario logado;

    /**
     * Login.
     *
     * @param usuario the usuario
     */
    public void login(Usuario usuario) {
        this.logado = usuario;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return logado.getNome();
    }

    /**
     * Checks if is logado.
     *
     * @return true, if is logado
     */
    public boolean isLogado() {
        return logado != null;
    }

    public void logout() {
        this.logado = null;
    }
}
