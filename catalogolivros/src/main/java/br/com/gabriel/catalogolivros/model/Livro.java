package br.com.gabriel.catalogolivros.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "livros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório.")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "O autor é obrigatório.")
    @Column(nullable = false)
    private String autor;

    @NotBlank(message = "A editora é obrigatória.")
    private String editora;

    @NotNull(message = "O ano de publicação é obrigatório.")
    private Integer anoPublicacao;

    @NotBlank(message = "O ISBN é obrigatório.")
    @Column(unique = true)
    private String isbn;

    @NotBlank(message = "A categoria é obrigatória.")
    private String categoria;
}