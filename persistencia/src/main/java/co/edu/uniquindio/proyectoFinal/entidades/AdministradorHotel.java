package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdministradorHotel extends Trabajador implements Serializable {

    @OneToMany (mappedBy = "administradorHotel")
    @ToString.Exclude
    private List<Hotel> hoteles;

}
