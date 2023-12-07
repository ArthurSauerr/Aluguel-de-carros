package com.alugarcarros.controller;

import com.alugarcarros.exceptions.AlugarCarrosException;
import com.alugarcarros.model.entidade.UsuarioVO;
import com.alugarcarros.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/usuarios")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioVO> listarTodos(){
        List<UsuarioVO> usuarios = usuarioService.listarTodos();
        return usuarios;
    }

    @PostMapping
    public UsuarioVO cadastrar(@RequestBody UsuarioVO novoUsuario) throws AlugarCarrosException {
        return usuarioService.inserir(novoUsuario);
    }

    @PutMapping
    public boolean atualizar(@RequestBody UsuarioVO usuarioAtualizar) throws AlugarCarrosException {
        return usuarioService.atualizar(usuarioAtualizar) != null;
    }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Integer id){
        return usuarioService.excluir(id);
    }

}
