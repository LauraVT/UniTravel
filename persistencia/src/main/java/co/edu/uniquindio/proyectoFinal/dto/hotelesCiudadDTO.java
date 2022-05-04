package co.edu.uniquindio.proyectoFinal.dto;

import co.edu.uniquindio.proyectoFinal.entidades.Ciudad;
import co.edu.uniquindio.proyectoFinal.entidades.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class hotelesCiudadDTO {

    private Ciudad ciudad;
    private int cantidadHotelesCiudad;
}
