package com.projeto_extensao.com.projeto_extensao.Repositorios;

import com.projeto_extensao.com.projeto_extensao.Entidades.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
