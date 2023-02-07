package com.pesnot.estado.msa.liquidacion.service.Impl;

import com.pesnot.estado.msa.liquidacion.domain.Tramite;
import com.pesnot.estado.msa.liquidacion.repository.TramiteRepository;
import com.pesnot.estado.msa.liquidacion.service.TramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TramiteServiceImpl implements TramiteService {
    @Autowired
    private final TramiteRepository tramiteRepository;

    public TramiteServiceImpl(TramiteRepository tramiteRepository) {
        this.tramiteRepository = tramiteRepository;
    }

    @Override
    public List<Tramite> listarTramites() {
        return tramiteRepository.findAll();
    }

    @Override
    public List<Tramite> listarTramitesActivos() {
        return tramiteRepository.listarTramitesActivos();
    }

    @Override
    public List<Tramite> listarTramitesNotaria(String id) {
        return tramiteRepository.listarTramitesNotaria(id);
    }

    @Override
    public List<Tramite> listarTramitesNotariaFecha(String id, Date fecha) {
        List<Tramite> listaEntrante = this.listarTramitesNotaria(id);
        List<Tramite> listaSaliente = new ArrayList<Tramite>();

        for (Tramite iteador : listaEntrante) {
            Date fecha2 = new Date(iteador.getFechaTramite().getTime());
            if (fecha2.equals(fecha)) {
                listaSaliente.add(iteador);
            }
        }
        return listaSaliente;
    }

    @Override
    public List<Tramite> listarTramitesNotariaFechaMes(String id, int mes) {
        List<Tramite> listaEntrante = this.listarTramitesNotaria(id);
        List<Tramite> listaSaliente = new ArrayList<Tramite>();
        for (Tramite iteador : listaEntrante) {
            Date date = iteador.getFechaTramite();
            if (date.getMonth() + 1 == mes) {
                listaSaliente.add(iteador);
            }
        }
        return listaSaliente;

    }

    @Override
    public Double calcularLiquidacionSinIVAParticipacionEstadoNotariaFechaMes(String id, int mes) {
        List<Tramite> listaEntrante = this.listarTramitesNotariaFechaMes(id,mes);
        Double valorTotalRecaudado=0.000;
        for(Tramite iteador : listaEntrante) {
            valorTotalRecaudado+=iteador.getValorTotalTramite();
        }
        return valorTotalRecaudado;
    }

    @Override
    public Optional<Tramite> buscarId(String id) {
        return tramiteRepository.findById(Long.parseLong(id));  //
    }

    @Override
    public Tramite guardarTramite(Tramite tramiteEntrante) {
        return tramiteRepository.save(tramiteEntrante);
    }

}
