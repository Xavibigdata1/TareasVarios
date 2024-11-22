package com.codigo_register_hexagonal.infraestructure.dao;

import com.codigo_register_hexagonal.infraestructure.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity,Long> {

}
