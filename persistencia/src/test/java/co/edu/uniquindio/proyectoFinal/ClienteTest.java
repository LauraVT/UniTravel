package co.edu.uniquindio.proyectoFinal;

import co.edu.uniquindio.proyectoFinal.entidades.Ciudad;
import co.edu.uniquindio.proyectoFinal.entidades.Cliente;
import co.edu.uniquindio.proyectoFinal.entidades.Hotel;
import co.edu.uniquindio.proyectoFinal.repositorios.CiudadRepo;
import co.edu.uniquindio.proyectoFinal.repositorios.ClienteRepo;
import co.edu.uniquindio.proyectoFinal.repositorios.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private HotelRepo hotelRepo;

    @Test
    public void registrar(){

        Ciudad ciudad1 = new Ciudad(4567,"Calarca");
        Ciudad ciudad1Guardada = ciudadRepo.save(ciudad1);

        Assertions.assertNotNull(ciudad1Guardada);

        Cliente cliente = new Cliente("1234","Laura",22,"laura@gmail.com","12345",ciudad1);

        Cliente clienteGuardado = clienteRepo.save(cliente);

        Assertions.assertNotNull(clienteGuardado);
    }

    @Test
    public void eliminar(){

        Ciudad ciudad1 = new Ciudad(4567,"Calarca");
        Ciudad ciudad1Guardada = ciudadRepo.save(ciudad1);

        Assertions.assertNotNull(ciudad1Guardada);

        Cliente cliente = new Cliente("1234","Laura",20,"laura@gmail.com","123456",ciudad1);

        Cliente clienteGuardado = clienteRepo.save(cliente);

        clienteRepo.delete(clienteGuardado);

        Cliente clienteBuscado = clienteRepo.findById("1234").orElse(null);
        Assertions.assertNull(clienteBuscado);

    }

    @Test
    public void actualizar(){

        Ciudad ciudad1 = new Ciudad(4567,"Calarca");
        Ciudad ciudad1Guardada = ciudadRepo.save(ciudad1);

        Assertions.assertNotNull(ciudad1Guardada);

        Cliente cliente = new Cliente("1234","Laura",22,"laura@gmail.com","12345",ciudad1);

        Cliente clienteGuardado = clienteRepo.save(cliente);

        clienteGuardado.setPassword("7894");

        clienteRepo.save(clienteGuardado);

        Cliente clienteBuscado = clienteRepo.findById("1234").orElse(null);
        Assertions.assertEquals("7894",clienteBuscado.getPassword());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Ciudad> ciudades = ciudadRepo.findAll();

        System.out.println(ciudades);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarCiudadId(){

        Ciudad ciudad = ciudadRepo.findById(2).orElse(null);
        System.out.println(ciudad);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesPorEstrellas(){

        List<Hotel> hoteles = hotelRepo.findAllByNombre("Hotel o");
        hoteles.forEach(System.out::println);

        List<Hotel> hoteles2 = hotelRepo.findAllByCodigo(1);
        hoteles2.forEach(System.out::println);

        List<Hotel> hoteles3 = hotelRepo.findAllByNumEstrellas(5);
        hoteles3.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarClientePorNombre() {

        List<Cliente> clientes = clienteRepo.clientesEncontrados("Juan");
        clientes.forEach(System.out::println);

        List<Cliente> clientes2 = clienteRepo.findAllByNombre("Luisa");
        clientes2.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void ClientePorEmailClave() {

        Optional<Cliente> cliente = clienteRepo.clientesEncontrados2("juan@gmal.com","5698");
        System.out.println(cliente);

        Optional<Cliente> cliente2 = clienteRepo.findByEmailAndPassword("luisa@gmail.com","8521");
        System.out.println(cliente2);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listaClientePagina() {

        Page<Cliente> clientes = clienteRepo.findAll(PageRequest.of(0,2));
        clientes.get().forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void dadoCiudadDevuelvaHoteles() {

       List<Hotel> hoteles = ciudadRepo.nombresHoteles(1);
        for (int i = 0; i < hoteles.size(); i++) {

            System.out.println(hoteles.get(i).getNombre());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void correoYComentarioCliente() {

        List<Object[]> clientes = clienteRepo.emailComentariosUsuario();
        clientes.forEach(c -> System.out.println(c[0]+"-"+c[1]));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void telefonosCliente() {

    List<String> clientes = clienteRepo.obtenerUsuariosTelefono();
    clientes.forEach(System.out::println);

    }


}
