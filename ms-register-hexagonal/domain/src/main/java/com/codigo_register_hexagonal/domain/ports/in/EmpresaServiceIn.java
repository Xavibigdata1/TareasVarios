package com.codigo_register_hexagonal.domain.ports.in;

import com.codigo_register_hexagonal.domain.aggregates.dto.EmpresaDto;

public interface EmpresaServiceIn {
    EmpresaDto createEmpresaIn(String ruc);

}
