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
@Table (name= "factura")

public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "fecha")
    private String fecha;

    @Column (name = "numero")
    private int numero;

    @Column (name = "total")
    private double total;


    @ManyToOne (cascade = CascadeType.PERSIST) //Si elimino la Factura no se elimina el cliente
    @JoinColumn (name = "fk_cliente")
    private Cliente cliente;


    @OneToMany (mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<DetalleFactura> detallesFactura = new HashSet<>();
}
