package com.codigo_register_hexagonal.infraestructure.adpters;

import com.codigo_register_hexagonal.domain.aggregates.constants.Constants;
import com.codigo_register_hexagonal.domain.aggregates.dto.EmpresaDto;
import com.codigo_register_hexagonal.domain.aggregates.response.ResponseSunat;
import com.codigo_register_hexagonal.domain.ports.out.EmpresaServiceOut;
import com.codigo_register_hexagonal.infraestructure.dao.EmpresaRepository;
import com.codigo_register_hexagonal.infraestructure.entity.EmpresaEntity;
import com.codigo_register_hexagonal.infraestructure.mapper.EmpresaMappers;
import com.codigo_register_hexagonal.infraestructure.rest.SunatClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmpresaAdapter implements EmpresaServiceOut {

    private final EmpresaRepository empresaRepository;
    private final SunatClient sunatClient;
    private final EmpresaMappers empresaMappers;

    @Value("${token.api}")
    private String token;

    @Override
    public EmpresaDto createEmpresaOut(String ruc) {
       EmpresaEntity empresa=getEntity(ruc);
       return empresaMappers.mapToDto(empresaRepository.save(empresa));
    }

    private EmpresaEntity getEntity(String ruc){

        ResponseSunat responseSunat=execute(ruc);
        if(Objects.nonNull(responseSunat)){
            return EmpresaEntity.builder()
                    .razonSocial(responseSunat.getRazonSocial())
                    .tipoDocumento(responseSunat.getTipoDocumento())
                    .numeroDocumento(responseSunat.getNumeroDocumento())
                    .estado(responseSunat.getEstado())
                    .condicion(responseSunat.getCondicion())
                    .direccion(responseSunat.getDireccion())
                    .ubigeo(responseSunat.getUbigeo())
                    .viaTipo(responseSunat.getViaTipo())
                    .viaNombre(responseSunat.getViaNombre())
                    .zonaCodigo(responseSunat.getZonaCodigo())
                    .zonaTipo(responseSunat.getZonaTipo())
                    .numero(responseSunat.getNumero())
                    .interior(responseSunat.getInterior())
                    .lote(responseSunat.getLote())
                    .dpto(responseSunat.getDpto())
                    .manzana(responseSunat.getManzana())
                    .kilometro(responseSunat.getKilometro())
                    .distrito(responseSunat.getDistrito())
                    .provincia(responseSunat.getProvincia())
                    .departamento(responseSunat.getDepartamento())
                    .esAgenteRetencion(responseSunat.isEsAgenteRetencion())
                    .tipo(responseSunat.getTipo())
                    .actividadEconomica(responseSunat.getActividadEconomica())
                    .numeroTrabajadores(responseSunat.getNumeroTrabajadores())
                    .tipoFacturacion(responseSunat.getTipoFacturacion())
                    .tipoContabilidad(responseSunat.getTipoContabilidad())
                    .comercioExterior(responseSunat.getComercioExterior())
                    .estado1(Constants.ACTIVE)
                    .usua_crea(Constants.USU_ADMIN)
                    .date_crea(new Timestamp(System.currentTimeMillis()))
                    .build();
        }
        return null;
    }

    private ResponseSunat execute(String ruc){
        String head="Bearer "+token;
        return sunatClient.getInfoSunat(ruc,head);
    }
}


