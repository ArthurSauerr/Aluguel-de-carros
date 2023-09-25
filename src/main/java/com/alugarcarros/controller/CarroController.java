package com.alugarcarros.controller;


import com.alugarcarros.exceptions.CampoInvalidoException;
import com.alugarcarros.model.entidade.CarroVO;
import com.alugarcarros.model.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/carros")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<CarroVO> listarTodos(){
    List<CarroVO> carros = carroService.listarTodos();
    return carros;
    }

    @PostMapping
    public CarroVO cadastrar(@RequestBody CarroVO novoCarro) throws CampoInvalidoException {
        return carroService.inserir(novoCarro);
    }

    @PutMapping
    public boolean atualizar(@RequestBody CarroVO carroAtualizar) throws CampoInvalidoException{
        return carroService.atualizar(carroAtualizar) != null;
    }

    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Integer id){
        return carroService.excluir(id);
    }
}
