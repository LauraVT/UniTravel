package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Persona implements Serializable {

    @ToString.Include
    @ManyToOne
    private Ciudad ciudad;

    @OneToMany (mappedBy = "cliente")
    @ToString.Exclude
    private List<Reserva> reservas;

    @OneToMany (mappedBy = "cliente")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @ElementCollection
    private List<String> telefonos;

    public Cliente(String cedula, String nombre, @Positive int edad, @Email String email, String password, Ciudad ciudad) {
        super(cedula, nombre, edad, email, password);
        this.ciudad = ciudad;
    }
}

