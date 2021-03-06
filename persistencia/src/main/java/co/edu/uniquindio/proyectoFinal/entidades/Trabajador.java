package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Trabajador extends Persona implements Serializable {

    @ManyToOne
    private Categoria categoria;
}
