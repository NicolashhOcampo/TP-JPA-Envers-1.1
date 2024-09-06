package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table (name= "domicilio")

public class Domicilio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "nombre_calle")
    private String nombreCalle;

    @Column (name = "numero")
    private int numero;

    @OneToOne (mappedBy = "domicilio")
    private Cliente cliente;

}
