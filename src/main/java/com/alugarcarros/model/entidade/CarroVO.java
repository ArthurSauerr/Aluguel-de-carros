package com.alugarcarros.model.entidade;


import jakarta.persistence.*;

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

    public CarroVO() {
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValor_semanal() {
        return valor_semanal;
    }

    public void setValor_semanal(double valor_semanal) {
        this.valor_semanal = valor_semanal;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public UsuarioVO getUsuarioComCarro() {
        return usuarioComCarro;
    }

    public void setUsuarioComCarro(UsuarioVO usuarioComCarro) {
        this.usuarioComCarro = usuarioComCarro;
    }
}
