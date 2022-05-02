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
public class Categoria implements Serializable {

    @Id
    @Column(length = 4)
    private int codigo;

    @Column(length = 20)
    private String tipo;

    @OneToOne(mappedBy = "categoria")
    private Descuento descuento;

  //  @OneToMany(mappedBy = "categoria")
  //  private List<Trabajador> trabajadores;
}
