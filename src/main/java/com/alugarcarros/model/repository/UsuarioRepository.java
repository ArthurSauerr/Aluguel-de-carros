package com.alugarcarros.model.repository;

import com.alugarcarros.model.entidade.UsuarioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioVO, Long>, JpaSpecificationExecutor<UsuarioVO> {

}
