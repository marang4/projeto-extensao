package com.projeto_extensao.com.projeto_extensao.Controllers;

import com.projeto_extensao.com.projeto_extensao.Entidades.Categoria;
import com.projeto_extensao.com.projeto_extensao.Entidades.Cidade;
import com.projeto_extensao.com.projeto_extensao.Repositorios.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Cidade> criarCidade(@RequestBody Cidade cidade){
        Cidade retorno =  cidadeRepository.save(cidade);
        if (retorno != null) {
            return ResponseEntity.ok().body(retorno);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cidade>> listarCidade() {
        List<Cidade> cidadeRetorno = cidadeRepository.findAll();

        return ResponseEntity.ok().body(cidadeRetorno);
    }

}
