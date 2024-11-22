package com.codigo_register_hexagonal.domain.ports.out;

import com.codigo_register_hexagonal.domain.aggregates.dto.EmpresaDto;

public interface EmpresaServiceOut {
    EmpresaDto createEmpresaOut(String ruc);
}
