package com.projeto_extensao.com.projeto_extensao.Controllers;

import com.projeto_extensao.com.projeto_extensao.Entidades.Categoria;
import com.projeto_extensao.com.projeto_extensao.Entidades.Empresa;
import com.projeto_extensao.com.projeto_extensao.Repositorios.CategoriaRepository;
import com.projeto_extensao.com.projeto_extensao.Repositorios.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria){
        Categoria retorno =  categoriaRepository.save(categoria);
        if (retorno != null) {
            return ResponseEntity.ok().body(retorno);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Categoria>> listarCategoria() {
        List<Categoria> categoriaRetorno = categoriaRepository.findAll();

        return ResponseEntity.ok().body(categoriaRetorno);
    }


    @GetMapping("/listcat/{id}")
    public ResponseEntity<Categoria> listarCategoriaEspecifica(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
