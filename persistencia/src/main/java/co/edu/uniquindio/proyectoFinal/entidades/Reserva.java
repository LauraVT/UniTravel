package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 50)
    @ToString.Include
    private int codigo;

    @Future
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @ToString.Include
    private LocalDate fechaReserva;

    @Future
    @Column(nullable = false)
    @ToString.Include
    private LocalDate fechaInicio;

    @Future
    @Column(nullable = false)
    @ToString.Include
    private LocalDate fechaFin;

    @EqualsAndHashCode.Include
    @Column(length = 9, nullable = false)
    private double precioTotal;

    @EqualsAndHashCode.Include
    @Column(length = 1, nullable = false)
    private int estado;

    @EqualsAndHashCode.Include
    @Column(length = 1, nullable = false)
    private int cantidadPersonasMayores;

    @EqualsAndHashCode.Include
    @Column(length = 1, nullable = false)
    private int cantidadPersonasMenores;

    @EqualsAndHashCode.Include
    @ManyToOne
    private Cliente cliente;

    @OneToMany (mappedBy = "reserva")
    @ToString.Exclude
    private List<Reserva_Silla> reservaSilla;

    @OneToMany (mappedBy = "reserva")
    @ToString.Exclude
    private List<Reserva_Habitacion> reservaHabitacion;

    @OneToMany(mappedBy = "reserva")
    @ToString.Exclude
    private List<Descuento> descuentos;

}
