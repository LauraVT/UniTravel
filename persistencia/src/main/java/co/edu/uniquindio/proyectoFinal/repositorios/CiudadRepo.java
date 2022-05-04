package co.edu.uniquindio.proyectoFinal.repositorios;

import co.edu.uniquindio.proyectoFinal.dto.hotelesCiudadDTO;
import co.edu.uniquindio.proyectoFinal.entidades.Administrador;
import co.edu.uniquindio.proyectoFinal.entidades.Ciudad;
import co.edu.uniquindio.proyectoFinal.entidades.Hotel;
import co.edu.uniquindio.proyectoFinal.entidades.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {

    @Query("select c.hoteles from Ciudad c where c.codigo = :idCiudad")
    List<Hotel> nombresHoteles(int idCiudad);

    //Cree una consulta que permita contar el número de hoteles que hay por cada ciudad. Use GROUP BY.
    //@Query("select new co.edu.uniquindio.proyectoFinal.dto.hotelesCiudadDTO(h.ciudad, count(h)) from Hotel h group by h.ciudad")
    //List<hotelesCiudadDTO> hotelesDeLaCiudad();

}
