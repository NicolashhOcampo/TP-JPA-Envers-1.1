package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited
@Table (name= "articulo")
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "cantidad")
    private int cantidad;

    @Column (name = "denominacion")
    private String denominacion;

    @Column (name = "precio")
    private int precio;


    @OneToMany (mappedBy = "articulo", cascade = CascadeType.PERSIST)
    @Builder.Default
    private Set<DetalleFactura> detallesFactura = new HashSet<>();


    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //Si se modifica Articulo categoria persiste o se actualiza
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )

    @Builder.Default
    private Set<Categoria> categorias = new HashSet<>();

}
