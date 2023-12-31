package ap.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data   // Getters y Setters
@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long

    @Column(name = "razon_social", nullable = false, length = 45)
    //@NotBlank (message = "La razon social no puede estar vacía")
    //@NotNull (message = "La razon social no puede estar vacía")
    private String razon_social;

    @Column(name = "cuit", nullable = false, length = 45)
    //@NotBlank (message = "El cuit no puede estar vacía")
    //@NotNull (message = "El cuit no puede estar vacía")
    private String cuit;

    /* CREO QUE TIENE QUE SE MANYtoMANY
    @OneToMany(cascade = CascadeType.PERSIST)     // un Tecnico puede tener varias Especialidades // PERSIST: cuando creo un Tecnico debería crear en el mismo momento la/las Especialidades
    @JoinColumn(name="tecnico_id", referencedColumnName="id") //nombre de la foreing key en tabla Especialidad
    private List<Servicio> servicios;
    */

    @ManyToMany(mappedBy="clientes", cascade = CascadeType.MERGE)   // varios Clientes pueden tener varios Servicios
    private List<Servicio> servicios;

    @ManyToMany(mappedBy="clientes", cascade = CascadeType.MERGE)   // varios Clientes pueden aparecer en varios Incidentes
    private List<Incidente> incidentes;
}
