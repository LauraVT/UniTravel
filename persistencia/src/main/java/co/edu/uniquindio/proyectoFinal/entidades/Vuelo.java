package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelo implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 4)
    private int codigo;

    @Column(length = 1, nullable = false)
    private int estado;

    @Column(length = 50, nullable = false)
    private String aerolinea;

    @OneToMany (mappedBy = "vuelo")
    private List<Silla> silla;

    @ManyToOne
    private Ciudad ciudadDestino;

    @ManyToOne
    private Ciudad ciudadOrigen;

}
