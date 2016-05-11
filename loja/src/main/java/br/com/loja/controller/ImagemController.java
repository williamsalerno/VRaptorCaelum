package br.com.loja.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;

import java.io.File;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.Validations;
import br.com.loja.modelo.Imagem;
import br.com.loja.modelo.Produto;

/**
 * The Class ImagemController.
 */
@Resource
public class ImagemController {

    /** The validator. */
    private final Validator validator;
    
    /** The imagem. */
    private final Imagem arquivo;
    
    /** The result. */
    private final Result result;

    /**
     * Instantiates a new imagem controller.
     *
     * @param validator the validator
     */
    public ImagemController(Validator validator, Imagem arquivo, Result result) {
        this.validator = validator;
        this.arquivo = arquivo;
        this.result = result;
    }

    /**
     * Upload.
     *
     * @param produto the produto
     * @param imagem the imagem
     */
    @Post("/produtos/{produto.id}/imagem")
    public void upload(Produto produto, final UploadedFile imagem) {
        validator.checking(new Validations() {
            {
                if (that(imagem, is(notNullValue()), "imagem", "imagem.nula")) {
                    that(imagem.getContentType(), startsWith("image"), "imagem", "nao.eh.imagem");
                }
            }
        });
        validator.onErrorRedirectTo(ProdutoController.class).edita(produto.getId());
        this.arquivo.salva(imagem, produto);
        result.redirectTo(ProdutoController.class).lista();
    }
    
    @Get("/produtos/{produto.id}/imagem")
    public File download(Produto produto){
        return arquivo.mostra(produto);
    }
}
