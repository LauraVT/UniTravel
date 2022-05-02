package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hotel implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 4)
    @ToString.Include
    private int codigo;

    @Column(length = 40,nullable = false)
    @ToString.Include
    private String nombre;

    @Column(length = 100,nullable = false,unique = true)
    private String direccion;

    @Column(length = 15,nullable = false)
    private String telefono;

    @Column(length = 10)
    @ToString.Include
    private int numEstrellas;

    @ManyToOne
    @ToString.Include
    private Ciudad ciudad;

    @OneToMany (mappedBy = "hotel")
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @ManyToMany (mappedBy = "hotel")
    @ToString.Exclude
    private List<Caracteristica> caracteristica;

    @OneToMany (mappedBy = "hotel")
    @ToString.Exclude
    private List<Comentario> comentario;

    @ManyToOne
    private AdministradorHotel administradorHotel;

    @ElementCollection
    private List<String> fotosHotel;

}
