package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Descuento implements Serializable {

    @Id
    @Column(length = 4)
    int codigo;

    @Column(length = 20)
    String estado;

    @Column(length = 15)
    String valorDescontar;

    @OneToOne
    private Categoria categoria;

    @ManyToOne
    private Reserva reserva;
}
