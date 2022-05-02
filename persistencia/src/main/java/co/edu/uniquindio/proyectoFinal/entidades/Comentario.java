package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @Column(length = 4)
    private int codigo;

    @Column(nullable = false)
    @ToString.Include
    private String comentario;

    @Column(length = 1)
    @ToString.Include
    private double calificacion;

    @Column(nullable = false)
    private LocalDate fechaCalificacion;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Hotel hotel;

}
