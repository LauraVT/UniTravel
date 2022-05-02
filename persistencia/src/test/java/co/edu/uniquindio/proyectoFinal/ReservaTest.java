package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.entidades.Reserva;
import co.edu.uniquindio.proyectoFinal.repositorios.ClienteRepo;
import co.edu.uniquindio.proyectoFinal.repositorios.ReservaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservaTest {

    @Autowired
    private ReservaRepo reservaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void listaReservas(){

        Page<Reserva> reserva = reservaRepo.findAll(PageRequest.of(0,4));
        reserva.get().forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void reservaHabitacionPorHotelPorFecha() {

        LocalDate fecha = LocalDate.of(2022,06,01);

        List<Object[]> reservas = reservaRepo.ObtenerDatos(1,fecha);
        reservas.forEach(c -> System.out.println(c[0]+" - "+c[1]+" - "+c[2]));
    }

}
