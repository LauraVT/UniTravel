package co.edu.uniquindio.proyectoFinal.repositorios;

import co.edu.uniquindio.proyectoFinal.entidades.Cliente;
import co.edu.uniquindio.proyectoFinal.entidades.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer> {

    Page<Reserva> findAll(Pageable pageable);

    @Query("select r.cliente.nombre, r.fechaReserva, rh.habitacion from Reserva r join r.reservaHabitacion rh where rh.habitacion.hotel.codigo = :codigoHotel and r.fechaInicio < :fecha ")
    List<Object[]> ObtenerDatos(int codigoHotel, LocalDate fecha);
}
