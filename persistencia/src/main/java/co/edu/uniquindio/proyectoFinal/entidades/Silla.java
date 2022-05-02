package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 4)
    private int codigo;

    @Column(length = 3, nullable = false, unique = true)
    private String posicion;

    @Column(length = 9, nullable = false)
    private double precio;

    @OneToMany (mappedBy = "silla")
    @ToString.Exclude
    private List<Reserva_Silla> reservaSilla;

    @ManyToOne
    private Vuelo vuelo;
}
