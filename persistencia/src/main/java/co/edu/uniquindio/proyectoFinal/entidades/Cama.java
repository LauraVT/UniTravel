package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cama implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 4)
    private int codigo;

    @Column(length = 1, nullable = false)
    private int tipo;

    @ManyToMany
    @ToString.Exclude
    private List<Habitacion> habitacion;
}
