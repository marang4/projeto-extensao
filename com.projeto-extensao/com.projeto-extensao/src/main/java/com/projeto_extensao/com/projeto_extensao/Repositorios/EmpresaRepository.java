package com.projeto_extensao.com.projeto_extensao.Repositorios;

import com.projeto_extensao.com.projeto_extensao.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
