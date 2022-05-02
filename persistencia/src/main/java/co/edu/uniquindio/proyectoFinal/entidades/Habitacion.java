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
public class Habitacion implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 4)
    private int numero;

    @ToString.Include
    @Column(length = 9, nullable = false)
    private double precio;

    @ToString.Include
    @Column(length = 1, nullable = false)
    private int capacidad;

    @ManyToOne
    private Hotel hotel;

    @ManyToMany (mappedBy = "habitacion")
    @ToString.Exclude
    private List<Caracteristica> caracteristica;

    @ManyToMany (mappedBy = "habitacion")
    @ToString.Exclude
    private List<Cama> cama;

    @OneToMany (mappedBy = "habitacion")
    @ToString.Exclude
    private List<Reserva_Habitacion> reservaHabitacion;

    @ElementCollection
    private List<String>fotosHabitacion;

}
