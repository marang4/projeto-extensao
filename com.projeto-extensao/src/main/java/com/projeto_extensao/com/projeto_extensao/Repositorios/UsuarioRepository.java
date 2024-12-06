package com.projeto_extensao.com.projeto_extensao.Repositorios;

import com.projeto_extensao.com.projeto_extensao.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
