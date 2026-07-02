package br.com.gabriel.catalogolivros.controller;

import br.com.gabriel.catalogolivros.model.Livro;
import br.com.gabriel.catalogolivros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    // Cadastrar livro
    @PostMapping
    public ResponseEntity<Livro> cadastrar(@Valid @RequestBody Livro livro) {
        Livro novoLivro = livroService.salvar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    // Listar todos os livros
    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

    // Buscar livro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar livro
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id,
                                           @Valid @RequestBody Livro livro) {

        Livro livroAtualizado = livroService.atualizar(id, livro);

        if (livroAtualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(livroAtualizado);
    }

    // Excluir livro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        if (livroService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        livroService.excluir(id);

        return ResponseEntity.noContent().build();
    }

}