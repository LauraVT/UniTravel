package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.*;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caracteristica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 4)
    private int codigo;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany
    @ToString.Exclude
    private List<Hotel> hotel;

    @ManyToMany
    @ToString.Exclude
    private List<Habitacion> habitacion;
}
