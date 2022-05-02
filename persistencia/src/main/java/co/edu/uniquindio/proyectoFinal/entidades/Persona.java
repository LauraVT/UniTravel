package co.edu.uniquindio.proyectoFinal.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 15)
    private String cedula;

    @Column(length = 50,nullable = false)
    private String nombre;

    @Positive
    @Column(length = 3, nullable = false)
    private int edad;

    @Email
    @Column(length = 50,unique = true)
    private String email;

    @Column(length = 20,unique = true, nullable = false)
    private String password;


}
