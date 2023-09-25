package com.alugarcarros.model.repository;

import com.alugarcarros.model.entidade.CarroVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<CarroVO, Long>, JpaSpecificationExecutor<CarroVO> {

}
