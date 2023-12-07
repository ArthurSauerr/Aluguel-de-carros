package com.alugarcarros.model.entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private String cpf;
    private String senha;

    public UsuarioDTO(){}

    public UsuarioDTO(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }
}
