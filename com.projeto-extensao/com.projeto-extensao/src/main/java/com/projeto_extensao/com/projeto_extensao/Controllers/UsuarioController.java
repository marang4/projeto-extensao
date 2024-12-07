package com.projeto_extensao.com.projeto_extensao.Controllers;

import com.projeto_extensao.com.projeto_extensao.Entidades.Usuario;
import com.projeto_extensao.com.projeto_extensao.Repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuariosRepository;

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario){
        Usuario retorno = usuariosRepository.findByEmail(usuario.getEmail());
        if (retorno != null) {
            if(retorno.getSenha().equals(usuario.getSenha())){
                return ResponseEntity.ok().body(retorno);
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

}
