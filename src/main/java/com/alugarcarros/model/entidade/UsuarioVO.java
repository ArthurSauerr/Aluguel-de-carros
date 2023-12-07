package com.alugarcarros.model.entidade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class UsuarioVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private LocalDate dt_nascimento;
    private String cpf;
    private String cnh;
    private String senha;
    private String status;

    @JsonBackReference
    @OneToMany(mappedBy = "usuarioComCarro")
    private List<CarroVO> carros;

    public UsuarioVO(Integer id, String nome, LocalDate dt_nascimento, String cpf, String cnh, List<CarroVO> carros, String senha, String status) {
        this.id = id;
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.cpf = cpf;
        this.cnh = cnh;
        this.carros = carros;
        this.senha = senha;
        this.status = status;
    }

    public UsuarioVO() { }

}
