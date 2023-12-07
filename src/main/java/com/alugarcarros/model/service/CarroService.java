package com.alugarcarros.model.service;

import com.alugarcarros.exceptions.AlugarCarrosException;
import com.alugarcarros.model.entidade.CarroVO;
import com.alugarcarros.model.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<CarroVO> listarTodos(){
        return carroRepository.findAll();
    }

    public CarroVO inserir(CarroVO novoCarro) throws AlugarCarrosException {
        return carroRepository.save(novoCarro);
    }

    public CarroVO atualizar(CarroVO carroAtualizar) throws AlugarCarrosException {
        validarCamposObrigatorios(carroAtualizar);
        return carroRepository.save(carroAtualizar);
    }

    public boolean excluir(Integer id){
        carroRepository.deleteById(id.longValue());
        return true;
    }

    private void validarCamposObrigatorios(CarroVO carro) throws AlugarCarrosException {
        String mensagemValidacao = "";
        mensagemValidacao += validarCampoString(carro.getFabricante(), "fabricante");
        mensagemValidacao += validarCampoString(carro.getModelo(), "modelo");
        mensagemValidacao += validarCampoString(carro.getTipo(), "tipo");
        mensagemValidacao += validarCampoString(carro.getPlaca(), "placa");
        mensagemValidacao += validarCampoString(carro.getCor(), "cor");
        mensagemValidacao += validarCampoDouble(carro.getValor_semanal(), "valor_semanal");
        mensagemValidacao += validarCampoBoolean(carro.isDisponivel(), "disponivel");

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

    private String validarCampoDouble(Double valorCampo, String nomeCampo) {
        if(valorCampo == null) {
            return "Informe o " + nomeCampo + " \n";
        }
        return "";
    }

    private String validarCampoBoolean(Boolean valorCampo, String nomeCampo){
        if(valorCampo == null){
            return "Informe o " +nomeCampo + " \n";
        }
        return "";
    }
}
