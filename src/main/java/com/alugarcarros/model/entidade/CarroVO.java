package com.alugarcarros.model.entidade;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carros")
public class CarroVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fabricante;
    private String modelo;
    private String tipo;
    private String placa;
    private String cor;
    private double valor_semanal;
    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioVO usuarioComCarro;

    public CarroVO(Integer id, String fabricante, String modelo, String tipo, String placa, String cor, double valor_semanal, boolean disponivel, UsuarioVO usuarioComCarro) {
        this.id = id;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tipo = tipo;
        this.placa = placa;
        this.cor = cor;
        this.valor_semanal = valor_semanal;
        this.disponivel = disponivel;
        this.usuarioComCarro = usuarioComCarro;
    }
    public CarroVO() {
    }
}
