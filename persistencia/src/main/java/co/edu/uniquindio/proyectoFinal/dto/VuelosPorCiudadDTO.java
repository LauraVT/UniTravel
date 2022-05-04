package co.edu.uniquindio.proyectoFinal.dto;

import co.edu.uniquindio.proyectoFinal.entidades.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class VuelosPorCiudadDTO {

    private Ciudad ciudadOrigen;
    private int codigoVuelo;
    private int estadoVuelo;
    private Ciudad ciudadDestino;
    //private int numRegistros;

}
