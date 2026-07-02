package br.com.gabriel.catalogolivros.exception;

public class LivroNaoEncontradoException extends RuntimeException {

    public LivroNaoEncontradoException(Long id) {
        super("Livro com ID " + id + " não encontrado.");
    }

}