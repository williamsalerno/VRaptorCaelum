package br.com.loja.modelo;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

/**
 * The Class Imagem.
 */
@Component
public class Imagem {

    /** The pasta imagem. */
    private File pastaImagem;

    /**
     * Instantiates a new imagem.
     *
     * @param context the context
     */
    public Imagem(ServletContext context) {
        String caminhoImagem = context.getRealPath("/images");
        pastaImagem = new File(caminhoImagem);
        pastaImagem.mkdir();
    }

    /**
     * Salva.
     *
     * @param imagem the imagem
     * @param produto the produto
     */
    public void salva(UploadedFile imagem, Produto produto) {
        File destino = new File(pastaImagem, produto.getId() + ".png");

        try {
            IOUtils.copy(imagem.getFile(), new FileOutputStream(destino));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao copiar imagem", e);
        }
    }

    /**
     * Mostra.
     *
     * @param produto the produto
     * @return the file
     */
    public File mostra(Produto produto) {
        return new File(pastaImagem, produto.getId() + ".png");
    }
}
