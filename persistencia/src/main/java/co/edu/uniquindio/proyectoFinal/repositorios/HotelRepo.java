package co.edu.uniquindio.proyectoFinal.repositorios;

import co.edu.uniquindio.proyectoFinal.entidades.Hotel;
import co.edu.uniquindio.proyectoFinal.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

    List<Hotel> findAllByNumEstrellas(int numEstrellas);
    List<Hotel> findAllByNombre(String nombre);
    List<Hotel> findAllByCodigo(int codigo);

    //Cree una consulta que permita determinar el número de reservas que tiene un hotel específico cuya
    //fecha de inicio de reserva aún no haya pasado.
    @Query("select count(r) from Reserva r join r.reservaHabitacion h where h.habitacion.hotel.codigo = :codigoHotel and r.fechaInicio > CURRENT_DATE ")
    int reservasHotel(int codigoHotel);
    //List<Reserva> reservasHotel (int codigoHotel);

    //Cree una consulta que permita determinar qué hoteles no tienen comentarios. Use IS EMPTY.
    @Query("select h from Hotel h where h.comentario is empty ")
    List<Hotel> hotelesNoComentados();

    //Cree una consulta que devuelva una lista con todos los hoteles que contengan en su nombre una cadena de búsqueda. Use LIKE.
    @Query("select h from Hotel h where h.nombre like '%tel%'")
    List<Hotel> busquedaNombreHotelPorCadena();
}

