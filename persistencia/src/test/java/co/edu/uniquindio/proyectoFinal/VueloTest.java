package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.dto.VuelosPorCiudadDTO;
import co.edu.uniquindio.proyectoFinal.repositorios.VueloRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VueloTest {

    @Autowired
    private VueloRepo vuelorepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void vuelosPorCiudad(){

        List<VuelosPorCiudadDTO> vuelodPorCiudad = vuelorepo.VuelosPorCiudad();
        vuelodPorCiudad.forEach(System.out::println);

        //List<Object[]> vuelodPorCiudad = vuelorepo.VuelosPorCiudad();
        //vuelodPorCiudad.forEach(r ->System.out.println(r[0]+" - "+r[1]+" - "+r[2]+" - "+r[3]+" - "+r[4]));


    }

}
