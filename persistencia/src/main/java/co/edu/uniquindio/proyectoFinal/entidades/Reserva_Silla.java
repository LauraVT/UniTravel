package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva_Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 4)
    private int codigo;

    @Positive
    @Column(length = 10,nullable = false)
    private double precioMayores;

    @Positive
    @Column(length = 10,nullable = false)
    private double precioMenores;

    @ManyToOne
    private Reserva reserva;

    @ManyToOne
    private Silla silla;

}
