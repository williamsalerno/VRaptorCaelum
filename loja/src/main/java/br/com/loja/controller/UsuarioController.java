package br.com.loja.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.loja.dao.UsuarioDAO;
import br.com.loja.modelo.Usuario;

/**
 * The Class UsuarioController.
 */
@Resource
public class UsuarioController {

    /** The user dao. */
    private final UsuarioDAO userDAO;
    
    /** The result. */
    private final Result result;
    
    /** The validator. */
    private final Validator validator;
    
    private final UsuarioWeb usuarioWeb;

    /**
     * Instantiates a new usuario controller.
     *
     * @param userDAO the user dao
     * @param result the result
     * @param validator the validator
     */
    public UsuarioController(UsuarioDAO userDAO, Result result, Validator validator, UsuarioWeb usuarioWeb) {
        this.userDAO = userDAO;
        this.result = result;
        this.validator = validator;
        this.usuarioWeb = usuarioWeb;
    }

    /**
     * Novo.
     */
    @Get("/novo")
    public void novo() {

    }

    /**
     * Login form.
     */
    @Get("/login")
    public void loginForm() {

    }
    
    /**
     * Login.
     *
     * @param usuario the usuario
     */
    @Post("/login")
    public void login(Usuario usuario) {
        Usuario carregado = userDAO.carrega(usuario);
        if(carregado == null) {
            validator.add(new ValidationMessage("Login e/ou senha inválidos", "usuario.login"));
        }
        validator.onErrorUsePageOf(UsuarioController.class).loginForm();
        usuarioWeb.login(carregado);
        result.redirectTo(ProdutoController.class).lista();
    }
    
    /**
     * Logout.
     */
    @Path("/logout")
    public void logout() {
        usuarioWeb.logout();
        result.redirectTo(ProdutoController.class).lista();
    }

    /**
     * Adiciona.
     *
     * @param usuario the usuario
     */
    @Post("/usuario")
    public void adiciona(Usuario usuario) {
        if (userDAO.existeUsuario(usuario)) {
            validator.add(new ValidationMessage("Login já existe", "usuario.login"));
        }
        validator.onErrorUsePageOf(this).novo();
        userDAO.adiciona(usuario);
        result.redirectTo(ProdutoController.class).lista();
    }
}
