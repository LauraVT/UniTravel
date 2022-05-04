package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.dto.hotelesCiudadDTO;
import co.edu.uniquindio.proyectoFinal.entidades.Hotel;
import co.edu.uniquindio.proyectoFinal.repositorios.CiudadRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {

    @Autowired
    private CiudadRepo ciudadRepo;


   /*  @Test
    @Sql("classpath:dataset.sql")
    public void hotelesDeLaCiudad(){

        List<hotelesCiudadDTO> hotelesCiudad = ciudadRepo.hotelesDeLaCiudad();
        hotelesCiudad.forEach(System.out::println);
    }*/
}
