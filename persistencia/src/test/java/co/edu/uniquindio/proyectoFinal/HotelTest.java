package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.entidades.Hotel;
import co.edu.uniquindio.proyectoFinal.entidades.Reserva;
import co.edu.uniquindio.proyectoFinal.repositorios.HotelRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotelTest {

    @Autowired
    private HotelRepo hotelrepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void reservasHotelPorFecha(){

       int reservasHotel = hotelrepo.reservasHotel(1);
        System.out.println(reservasHotel);
       //reservasHotel.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void hotelesComentados(){

        List<Hotel> hoteles = hotelrepo.hotelesNoComentados();
        hoteles.forEach(System.out::println);
        //reservasHotel.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void busquedaNombreHotelPorCadena(){

        List<Hotel> hoteles = hotelrepo.busquedaNombreHotelPorCadena();
        hoteles.forEach(System.out::println);
        //reservasHotel.forEach(System.out::println);
    }
}
