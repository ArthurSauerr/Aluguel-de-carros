package com.alugarcarros.model.entidade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UsuarioVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dt_nascimento;
    private String cpf;
    private String cnh;
    private boolean adm;

    @JsonBackReference
    @OneToMany(mappedBy = "usuarioComCarro")
    private List<CarroVO> carros;

    public UsuarioVO() { super(); }

    public UsuarioVO(Integer id, String nome, String email, String senha, LocalDate dt_nascimento, String cpf, String cnh, boolean adm, List<CarroVO> carros) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dt_nascimento = dt_nascimento;
        this.cpf = cpf;
        this.cnh = cnh;
        this.adm = adm;
        this.carros = carros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public List<CarroVO> getCarros() {
        return carros;
    }

    public void setCarros(List<CarroVO> carros) {
        this.carros = carros;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }
}
