package com.pesnot.estado.msa.liquidacion.service.Impl;

import com.pesnot.estado.msa.liquidacion.domain.ActoTramite;
import com.pesnot.estado.msa.liquidacion.domain.Tramite;
import com.pesnot.estado.msa.liquidacion.repository.TramiteRepository;
import com.pesnot.estado.msa.liquidacion.service.ActoTramiteService;
import com.pesnot.estado.msa.liquidacion.service.TramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TramiteServiceImpl implements TramiteService {
    @Autowired
    private final TramiteRepository tramiteRepository;
    @Autowired
    ActoTramiteService actoTramiteService;

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
        List<Tramite> listaEntrante = this.listarTramitesNotariaFechaMes(id, mes);
        Double valorTotalRecaudado = 0.000;
        for (Tramite iteador : listaEntrante) {
            valorTotalRecaudado += iteador.getValorTotalTramite();
        }
        return valorTotalRecaudado;
    }

    @Override
    public String calcularParticipacionEstadoParticipacionEstadoNotariaFechaMes(String id, int mes) {
        List<Tramite> listaEntrante = this.listarTramitesNotariaFechaMes(id, mes);
        Double valorTotalRecaudado = 0.000;
        Double otrosValores = 0.000;
        Double valoresNotasCredito = 0.000;
        Double valorCalculoParticipacion = 0.000;
        //TODO parametro del sistema, configurar
        Double remuneracionServidorJudidicialCat5 = 5011.000;
        int posicion = -1;

        for (Tramite tramiteActual : listaEntrante) {

            posicion += 1;
            valorTotalRecaudado += tramiteActual.getValorTotalTramite();
            // TODO SUMATORIA Otros valores
            otrosValores += 0;

            if (tramiteActual.getObservacionTramite().trim().toLowerCase() == "notadecredito" || tramiteActual.getObservacionTramite().trim().toLowerCase() == "notadecredito") {
                valoresNotasCredito += 0;
            }

            if (valorTotalRecaudado > remuneracionServidorJudidicialCat5) {

                valorTotalRecaudado = valorTotalRecaudado - tramiteActual.getValorTotalTramite();
                //TODO valor de otros valores
                otrosValores = otrosValores - 0;
                break;
            }
        }
        valorCalculoParticipacion = remuneracionServidorJudidicialCat5 - (valorTotalRecaudado - valoresNotasCredito - otrosValores);

        for (int idN = posicion; idN < listaEntrante.size(); idN++) {
            Tramite tramiteActual = listaEntrante.get(idN);
            List<ActoTramite> actosAsociados = actoTramiteService.listarActoTramitePorId(tramiteActual.getId().toString());
            System.out.println("Actos asociados " + actosAsociados);
            double particpacionEstado = 0.000;
            for (int fin = actosAsociados.size() - 1; fin > 0; fin--) {
                if (valorCalculoParticipacion == 0) {
                    break;
                }
                Double valorActoTramite = actosAsociados.get(fin).getValorActoTramiteActoTramite();
                if (valorActoTramite > valorCalculoParticipacion) {
                    particpacionEstado = valorCalculoParticipacion * actosAsociados.get(fin).getValorParticipacionEstadoActoTramite();
                    valorCalculoParticipacion = 0.00;
                } else if (valorActoTramite < valorCalculoParticipacion) {
                    particpacionEstado = particpacionEstado + (valorActoTramite * actosAsociados.get(fin).getValorParticipacionEstadoActoTramite());
                    valorCalculoParticipacion = valorActoTramite - valorCalculoParticipacion;
                }
            }
            tramiteActual.setValorParticipacionEstadoTramite(particpacionEstado);
            tramiteRepository.save(tramiteActual);
        }
        return "OK";

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
