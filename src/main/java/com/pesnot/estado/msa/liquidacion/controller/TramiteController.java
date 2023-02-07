package com.pesnot.estado.msa.liquidacion.controller;

import com.pesnot.estado.msa.liquidacion.domain.Tramite;
import com.pesnot.estado.msa.liquidacion.service.TramiteService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/tramites")
public class TramiteController {

    private final TramiteService tramiteService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramites() {
        return this.tramiteService.listarTramites();
    }

    @GetMapping(value = "activos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramitesActivos() {
        return this.tramiteService.listarTramitesActivos();
    }

    @GetMapping(value = "notaria/{notaria}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramitesNotaria(@PathVariable String notaria) {
        return this.tramiteService.listarTramitesNotaria(notaria);
    }
    @PostMapping(value = "notaria", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramitesNotariaP(@RequestParam(required = false) String notaria) {
        return this.tramiteService.listarTramitesNotaria(notaria);
    }
    @PostMapping(value = "notaria/fecha", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramitesNotariaP(@RequestParam(required = false) String notaria, @DateTimeFormat(pattern = "dd-M-yyyy") Date fecha) {
        return this.tramiteService.listarTramitesNotariaFecha(notaria, fecha);
    }
    @PostMapping(value = "notaria/fecha/mes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramitesNotariaMes(@RequestParam(required = false) String notaria, @RequestParam(required = false) int mes) {
        return this.tramiteService.listarTramitesNotariaFechaMes(notaria,mes);
    }
    @GetMapping(value = "notaria/{notaria}/mes/{mes}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double listarTramitesNotaria(@PathVariable String notaria, @PathVariable int mes) {
        return this.tramiteService.calcularLiquidacionSinIVAParticipacionEstadoNotariaFechaMes(notaria, mes);
    }

    @GetMapping(value = "id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Tramite> listarTramiteId(@PathVariable String idEntrante) {
        return this.tramiteService.buscarId(idEntrante);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tramite guardarTramites(@RequestParam(required = false) Tramite tramiteEntrante) {
        return this.tramiteService.guardarTramite(tramiteEntrante);
    }


}
