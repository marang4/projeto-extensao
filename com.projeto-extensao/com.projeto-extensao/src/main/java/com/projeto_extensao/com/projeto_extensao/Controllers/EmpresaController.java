package com.projeto_extensao.com.projeto_extensao.Controllers;

import com.projeto_extensao.com.projeto_extensao.Entidades.Empresa;
import com.projeto_extensao.com.projeto_extensao.Repositorios.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Empresa> criarempresa(@RequestBody Empresa empresa){
        Empresa retorno =  empresaRepository.save(empresa);
        if (retorno != null) {
            return ResponseEntity.ok().body(retorno);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Empresa>> listarEmpresa() {
        List<Empresa> produtoRetorno = empresaRepository.findAll();

        return ResponseEntity.ok().body(produtoRetorno);
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id){   //void entre <> por que nao tem retorno

        empresaRepository.deleteById(id);

        return ResponseEntity.ok().body(null);

    }


}
