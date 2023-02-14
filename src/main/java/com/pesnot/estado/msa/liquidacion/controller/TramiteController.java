package com.pesnot.estado.msa.liquidacion.controller;

import com.pesnot.estado.msa.liquidacion.domain.Tramite;
import com.pesnot.estado.msa.liquidacion.service.TramiteService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/tramites")
@CrossOrigin(origins ="*", allowedHeaders ="*")
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

    @GetMapping(value = "id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Tramite> listarTramiteId(@PathVariable String id) {
        return this.tramiteService.buscarId(id);
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
        return this.tramiteService.listarTramitesNotariaFechaExacta(notaria, fecha);
    }
    @PostMapping(value = "notaria/fecha/mes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramitesNotariaMes(@RequestParam(required = false) String notaria, @RequestParam(required = false) int mes) {
        return this.tramiteService.listarTramitesNotariaFechaMes(notaria,mes);
    }
    @PostMapping(value = "notaria/fecha/mes/año", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tramite> listarTramitesNotariaMes(@RequestParam(required = false) String notaria, @RequestParam(required = false) int mes, @RequestParam(required = false) int año) {
        return this.tramiteService.listarTramitesNotariaFechaMesAño(notaria,mes,año);
    }
    @PostMapping(value = "calcularParticipacionEstado", produces = MediaType.APPLICATION_JSON_VALUE)
    public String participacionEstadoPost(@RequestParam(required = false) String notaria,@RequestParam(required = false) int mes, @RequestParam(required = false)int año) {
        return this.tramiteService.calcularTotalParticipacionEstadoTramitesNotariaFechaMesAño(notaria, mes,año);
    }
    @GetMapping(value = "calcularParticipacionEstado/notaria/{notaria}/mes/{mes}/year/{anio}", produces = MediaType.APPLICATION_JSON_VALUE)
        public String listarTramitesNotariaI(@PathVariable String notaria, @PathVariable int mes, @PathVariable int anio) {
        return this.tramiteService.calcularTotalParticipacionEstadoTramitesNotariaFechaMesAño(notaria, mes,anio);
    }
    @GetMapping(value = "calculoSinIva/notaria/{notaria}/mes/{mes}/year/{anio}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double CalcularValorSinIva(@PathVariable String notaria, @PathVariable int mes, @PathVariable int anio) {
        return this.tramiteService.calcularValorSinIvaNotariaFechaMes(notaria,mes,anio);
    }
    @GetMapping(value = "calculoParticipacionEstadoGeneral/notaria/{notaria}/mes/{mes}/year/{anio}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double CalcularParticipacionEstado(@PathVariable String notaria, @PathVariable int mes, @PathVariable int anio) {
        return this.tramiteService.calcularParticipacionEstadoTramitesNotariaFechaMesAño(notaria,mes,anio);
    }
    @GetMapping(value = "calculoOtrosValores/notaria/{notaria}/mes/{mes}/year/{anio}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double CalcularOtrosValores(@PathVariable String notaria, @PathVariable int mes, @PathVariable int anio) {
        return this.tramiteService.calcularOtrosValoresNotariaFechaMes(notaria,mes,anio);
    }
    @PostMapping(value = "calculoOtrosValoresDepositar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double CalcularOtrosValores(@RequestParam(required = false) Double participacionEstado, @RequestParam(required = false) Double multas,@RequestParam(required = false) Double intereses,@RequestParam(required = false) Double notasCredito,@RequestParam(required = false) Double pagoExceso) {
        return this.tramiteService.calcularValorDepositarNotariaFechaMesAño(participacionEstado,multas,intereses,notasCredito,pagoExceso);
    }
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tramite guardarTramites(@RequestParam(required = false) Tramite tramiteEntrante) {
        return this.tramiteService.guardarTramite(tramiteEntrante);
    }


}
