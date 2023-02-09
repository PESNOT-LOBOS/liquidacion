package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="ParametroCatalogo")
public class Parametro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idParametrocatalogo")
	private Long idParametro;
	
	@ManyToOne(targetEntity = Catalogo.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCatalogo",nullable=false)
	@JsonProperty(access = Access.READ_WRITE)
	private Catalogo idCatalogo;
	@Column(name="numeroVersionParametroCatalogo")
	private Long numero;
	@Column(name="descripcionParametroCatalogo")
	private String descripcion;
	@Column(name="fechaParametroCatalogo")
	private Date fecha;
	@Column(name="fechaInicioParametroCatalogo")
	private Date fechaInicio;
	@Column(name="fechaFinParametroCatalogo")
	private Date fechaFin;
	@Column(name="estadoActivo")
	private boolean estadoActivo;
	@Column(name="estadoParametroCatalogo")
	private boolean estadoParametroCatalogo;
	@Column(name="nombreParametroCatalogo")
	private String nombreParametro;
	@Column(name="valorParametroCatalogo")
	private Long valorParametro;

	public Parametro() {
		
	}
	public Parametro(Long idParametro, Catalogo idCatalogo, Long numero, String descripcion, Date fecha,
			Date fechaInicio, Date fechaFin, boolean estadoActivo, boolean estadoParametroCatalogo,
			String nombreParametro, Long valorParametro) {
		super();
		this.idParametro = idParametro;
		this.idCatalogo = idCatalogo;
		this.numero = numero;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estadoActivo = estadoActivo;
		this.estadoParametroCatalogo = estadoParametroCatalogo;
		this.nombreParametro = nombreParametro;
		this.valorParametro = valorParametro;
	}
	public Parametro(Catalogo idCatalogo, Long numero, String descripcion, Date fecha, Date fechaInicio, Date fechaFin,
			boolean estadoActivo, boolean estadoParametroCatalogo, String nombreParametro, Long valorParametro) {
		super();
		this.idCatalogo = idCatalogo;
		this.numero = numero;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estadoActivo = estadoActivo;
		this.estadoParametroCatalogo = estadoParametroCatalogo;
		this.nombreParametro = nombreParametro;
		this.valorParametro = valorParametro;
	}
	public Long getIdParametro() {
		return idParametro;
	}
	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}
	public Catalogo getIdCatalogo() {
		return idCatalogo;
	}
	public void setIdCatalogo(Catalogo idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public boolean isEstadoActivo() {
		return estadoActivo;
	}
	public void setEstadoActivo(boolean estadoActivo) {
		this.estadoActivo = estadoActivo;
	}
	public boolean isEstadoParametroCatalogo() {
		return estadoParametroCatalogo;
	}
	public void setEstadoParametroCatalogo(boolean estadoParametroCatalogo) {
		this.estadoParametroCatalogo = estadoParametroCatalogo;
	}
	public String getNombreParametro() {
		return nombreParametro;
	}
	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}
	public Long getValorParametro() {
		return valorParametro;
	}
	public void setValorParametro(Long valorParametro) {
		this.valorParametro = valorParametro;
	}
	@Override
	public String toString() {
		return "Parametro [idParametro=" + idParametro + ", idCatalogo=" + idCatalogo + ", numero=" + numero
				+ ", descripcion=" + descripcion + ", fecha=" + fecha + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", estadoActivo=" + estadoActivo + ", estadoParametroCatalogo=" + estadoParametroCatalogo
				+ ", nombreParametro=" + nombreParametro + ", valorParametro=" + valorParametro + "]";
	}
	
	
	
}