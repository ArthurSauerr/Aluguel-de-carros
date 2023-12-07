package com.alugarcarros.model.service;

import com.alugarcarros.exceptions.AlugarCarrosException;
import com.alugarcarros.model.entidade.UsuarioVO;
import com.alugarcarros.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioVO> listarTodos(){ return usuarioRepository.findAll(); }

    public UsuarioVO inserir(UsuarioVO novoUsuario) throws AlugarCarrosException {
        return usuarioRepository.save(novoUsuario);
    }

    public UsuarioVO atualizar(UsuarioVO usuarioAtualizar) throws AlugarCarrosException {
        validarCamposObrigatorios(usuarioAtualizar);
        return usuarioRepository.save(usuarioAtualizar);
    }

    public boolean excluir(Integer id){
        usuarioRepository.deleteById(id.longValue());
        return true;
    }

    private void validarCamposObrigatorios(UsuarioVO usuario) throws AlugarCarrosException {
        String mensagemValidacao = "";
        mensagemValidacao += validarCampoString(usuario.getNome(), "nome");
        mensagemValidacao += validarCampoString(usuario.getCpf(), "cpf");
        mensagemValidacao += validarCampoString(usuario.getCnh(), "cnh");
        mensagemValidacao += validarCampoString(usuario.getSenha(), "senha");

        if(!mensagemValidacao.isEmpty()){
            throw new AlugarCarrosException(mensagemValidacao);
        }

    }

    private String validarCampoString(String valorCampo, String nomeCampo) {
        if(valorCampo == null || valorCampo.trim().isEmpty()){
            return "Informe o " +nomeCampo + " \n";
        }
        return "";
    }

}
