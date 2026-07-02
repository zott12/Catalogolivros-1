package br.com.gabriel.catalogolivros.repository;

import br.com.gabriel.catalogolivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}