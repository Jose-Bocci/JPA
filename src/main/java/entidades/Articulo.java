package entidades;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulo")
@Audited
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio")
    private int precio;
    @Column(name = "denominacion")
    private String denominacion;


    @OneToMany(mappedBy = "articulo",cascade = CascadeType.PERSIST)
    private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "articulo_categoria", joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<Categoria>();


    public Articulo() {
    }

    public Articulo(int cantidad, int precio, String denominacion) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.denominacion = denominacion;
    }

    public Articulo(int cantidad, int precio, String denominacion, List<DetalleFactura> detalle) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.denominacion = denominacion;
        this.detalle = detalle;
    }

    public Articulo(int cantidad, int precio, String denominacion, List<DetalleFactura> detalle, List<Categoria> categorias) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.denominacion = denominacion;
        this.detalle = detalle;
        this.categorias = categorias;
    }

    public List<DetalleFactura> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleFactura> detalle) {
        this.detalle = detalle;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}
