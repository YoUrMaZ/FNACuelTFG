package es.manu.proyectofinaldespring.entidades;



import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;

    @Column(name = "imagen", nullable = false, length = 512)
    private String imagen;

    @OneToMany(mappedBy = "categoria", orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    @OneToMany(mappedBy = "categoria", orphanRemoval = true)
    private List<Digital> digitales = new ArrayList<>();

    @OneToMany(mappedBy = "categoria", orphanRemoval = true)
    private List<Servicio> servicios = new ArrayList<>();

    public Categoria(Long id, String nombre, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Categoria(){}


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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}