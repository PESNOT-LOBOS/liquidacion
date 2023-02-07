package com.pesnot.estado.msa.liquidacion.service.Impl;

import com.pesnot.estado.msa.liquidacion.domain.ActoTramite;
import com.pesnot.estado.msa.liquidacion.domain.Tramite;
import com.pesnot.estado.msa.liquidacion.repository.ActoTramiteRepository;
import com.pesnot.estado.msa.liquidacion.service.ActoTramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ActoTramiteServiceImpl implements ActoTramiteService {
    @Autowired
    private final ActoTramiteRepository actoTramiteRepository;

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
    public List<Tramite> calcularParticipacionEstado(int idDesde, double valorCalculo, List<Tramite> listaCalcularParticipacion) {

        for (int id = idDesde; id < listaCalcularParticipacion.size(); id++) {
            Tramite tramiteActual = listaCalcularParticipacion.get(id);
            List<ActoTramite> actosAsociados = actoTramiteRepository.listarActosIdTramites(tramiteActual.getId().toString());
            System.out.println("Actos asociados " + actosAsociados);
            double particpacionEstado=0.000;
            if (id == idDesde) {
                for (int fin = actosAsociados.size() - 1; fin > 0; fin--) {
                    if(valorCalculo==0){
                        break;
                    }
                    if (actosAsociados.get(fin).getValorActoTramiteActoTramite() > valorCalculo) {
                        particpacionEstado = valorCalculo * actosAsociados.get(fin).getValorParticipacionEstadoActoTramite();
                        valorCalculo=0;
                    } else if (actosAsociados.get(fin).getValorActoTramiteActoTramite() < valorCalculo) {
                        particpacionEstado=actosAsociados.get(fin).getValorActoTramiteActoTramite()* actosAsociados.get(fin).getValorParticipacionEstadoActoTramite();
                        valorCalculo=actosAsociados.get(fin).getValorActoTramiteActoTramite()-valorCalculo;
                    }
                }
            }
        }
        return listaCalcularParticipacion;
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
