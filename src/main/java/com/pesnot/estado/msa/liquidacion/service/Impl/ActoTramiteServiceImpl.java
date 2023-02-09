package com.pesnot.estado.msa.liquidacion.service.Impl;

import com.pesnot.estado.msa.liquidacion.domain.*;
import com.pesnot.estado.msa.liquidacion.repository.ActoTramiteRepository;
import com.pesnot.estado.msa.liquidacion.service.ActoTramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ActoTramiteServiceImpl implements ActoTramiteService {
    @Autowired
    private final ActoTramiteRepository actoTramiteRepository;
    @Autowired
    RestTemplate restTemplate;

    public Long getSBUParametro() {
        Long SBU = null;
        try {
            ResponseEntity<Parametro> response = restTemplate.getForEntity("https://pesnot.net/m04-admpes-api-parametros-0.0.1-SNAPSHOT/v1/parametros/nombre/SBU", Parametro.class);
            Parametro parametro = response.getBody();
            SBU = parametro.getValorParametro();
        } catch (NullPointerException e) {
            System.out.println("No se obtuvo nada, revise bien los parametros mandados");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return SBU;
    }

    public ActoNotarial getActoNotarial(String idActo) {
        ActoNotarial acto = null;
        try {
            ResponseEntity<ActoNotarial> response = restTemplate.getForEntity("https://pesnot.net/m04-admpes-api-actosnotariales-0.0.1/v1/actosNotariales/" + idActo, ActoNotarial.class);
            acto = response.getBody();
        } catch (NullPointerException e) {
            System.out.println("No se obtuvo nada, revise bien los parametros mandados");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return acto;

    }

    public TablaTarifaCatalogoActo getActoTabla(String idActo, String idTabla) {
        TablaTarifaCatalogoActo tablaActo = null;
        try {
            ResponseEntity<TablaTarifaCatalogoActo> response = restTemplate.getForEntity("https://pesnot.net/m04-admpes-api-actosnotariales-0.0.1/v1/tablaActos/tabla/" + idTabla + "/acto/" + idActo, TablaTarifaCatalogoActo.class);
            tablaActo = response.getBody();
        } catch (NullPointerException e) {
            System.out.println("No se obtuvo nada, revise bien los parametros mandados");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tablaActo;

    }

    public TablaTarifaRango getTaRangosTabla(String idTabla) {
        TablaTarifaRango tablaRango = null;
        try {
            ResponseEntity<TablaTarifaRango> response = restTemplate.getForEntity("https://pesnot.net/m04-admpes-api-actosnotariales-0.0.1/v1/tablaRangos/tabla/" + idTabla, TablaTarifaRango.class);
            tablaRango = response.getBody();
        } catch (NullPointerException e) {
            System.out.println("No se obtuvo nada, revise bien los parametros mandados");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tablaRango;
    }


    public ActoTramiteServiceImpl(ActoTramiteRepository actoTramiteRepository) {
        this.actoTramiteRepository = actoTramiteRepository;
    }

    @Override
    public List<ActoTramite> listarActoTramites() {
        return actoTramiteRepository.findAll();
    }

    @Override
    public List<ActoTramite> listarActoTramitesActivos() {
        return actoTramiteRepository.listarActosTramiteActivos();
    }

    @Override
    public List<ActoTramite> listarActosIdTramite(String idTramite) {
        return actoTramiteRepository.listarActosIdTramites(idTramite);
    }

    @Override
    public List<ActoTramite> listarIdActosTramite(String idActos) {
        return actoTramiteRepository.listarIdActoTramites(idActos);
    }

    @Override
    public List<ActoTramite> listarActoTramitePorId(String idTramite) {
        return actoTramiteRepository.listarActosIdTramites(idTramite);
    }

    @Override
    public String calcularParticipacionEstadoDeValor() {
        List<ActoTramite> actosFacturados = actoTramiteRepository.findAll();
        for (ActoTramite actoTramite : actosFacturados) {
            //TODO deberia traer el valor de la tabla o motivo utilizado
            Double idTabla = null;
            Double idMotivo = null;
            Double SBU = this.getSBUParametro().doubleValue();
            Double porcentaje = actoTramite.getValorActoTramiteActoTramite() / SBU;
            //TODO esta de mas esto, solo con traer el objeto
            ActoNotarial acto = getActoNotarial(actoTramite.getIdCatalogoActoNotarial().toString());
            TablaTarifaCatalogoActo tablaActo = getActoTabla(acto.getIdCatalogoActoNotarial().toString(), idTabla.toString());
            TablaTarifaRango tablaTarifa = getTaRangosTabla(tablaActo.getIdTablaTarifa().toString());

            if (acto.getUsaCalculoTablaCatalogoActoNotarial()) {
                if (tablaTarifa.getPorcentajeTablaTarifaRango() == porcentaje) {
                    actoTramite.setValorParticipacionEstadoActoTramite(tablaTarifa.getPorcentajeParticipacionEstadoTablaTarifaRango());
                    actoTramite.setValorParticipacionNotarioActoTramite(tablaTarifa.getPorcentajeParticipacionNotarioTablaTarifaRango());
                    this.actoTramiteRepository.save(actoTramite);
                    return "OK";
                }

            } else if (!acto.getUsaCalculoTablaCatalogoActoNotarial()) {
                System.out.println("FALTAAAAAAAA");
            }

        }
        return "OK";
    }

    @Override
    public Optional<ActoTramite> buscarId(String id) {
        return actoTramiteRepository.findById(Long.parseLong(id));
    }

    @Override
    public ActoTramite guardarActoTramite(ActoTramite tramiteEntrante) {
        return actoTramiteRepository.save(tramiteEntrante);
    }
}
