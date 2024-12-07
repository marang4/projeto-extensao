package com.projeto_extensao.com.projeto_extensao.Repositorios;

import com.projeto_extensao.com.projeto_extensao.Entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

   List<Categoria> findById(long id);

}
