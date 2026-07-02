package br.com.gabriel.catalogolivros.service;

import br.com.gabriel.catalogolivros.exception.LivroNaoEncontradoException;
import br.com.gabriel.catalogolivros.model.Livro;
import br.com.gabriel.catalogolivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    // Cadastrar livro
    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    // Listar todos os livros
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    // Buscar por ID
    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    // Atualizar livro
    public Livro atualizar(Long id, Livro livroAtualizado) {

        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new LivroNaoEncontradoException(id));

        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setEditora(livroAtualizado.getEditora());
        livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
        livro.setIsbn(livroAtualizado.getIsbn());
        livro.setCategoria(livroAtualizado.getCategoria());

        return livroRepository.save(livro);
    }

    // Excluir livro
    public void excluir(Long id) {

        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new LivroNaoEncontradoException(id));

        livroRepository.delete(livro);
    }
}