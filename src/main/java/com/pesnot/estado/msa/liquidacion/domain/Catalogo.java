package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo;


import javax.persistence.*;

@Entity
@Table(name = "Catalogo")

public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCatalogo")
    private Long id;
    @Column(name = "nombreCatalogo")
    private String nombre;
    @Column(name = "estadoCatalogo")
    private Boolean estadoCatalogo;
    @Column(name = "estadoActivo")
    private Boolean estadoActivo;


    public Catalogo() {
    }

    public Catalogo(Long id, String nombre, Boolean estadoCatalogo, Boolean estadoActivo) {
        this.id = id;
        this.nombre = nombre;
        this.estadoCatalogo = estadoCatalogo;
        this.estadoActivo = estadoActivo;
    }

    public Catalogo(String nombre, Boolean estadoCatalogo, Boolean estadoActivo) {
        this.nombre = nombre;
        this.estadoCatalogo = estadoCatalogo;
        this.estadoActivo = estadoActivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean isEstadoCatalogo() {
        return estadoCatalogo;
    }

    public void setEstadoCatalogo(Boolean estadoCatalogo) {
        this.estadoCatalogo = estadoCatalogo;
    }

    public Boolean isEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(Boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    @Override
    public String toString() {
        return "Catalogo [id=" + id + ", nombre=" + nombre + ", estadoCatalogo=" + estadoCatalogo + ", estadoActivo="
                + estadoActivo + "]";
    }


}
