package com.alugarcarros.model.service;

import com.alugarcarros.exceptions.CampoInvalidoException;
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

    public CarroVO inserir(CarroVO novoCarro) throws CampoInvalidoException {
        return carroRepository.save(novoCarro);
    }

}
