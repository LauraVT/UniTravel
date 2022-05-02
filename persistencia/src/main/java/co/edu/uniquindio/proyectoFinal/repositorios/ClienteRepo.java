package co.edu.uniquindio.proyectoFinal.repositorios;

import co.edu.uniquindio.proyectoFinal.entidades.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {

    @Query("select c from Cliente c where c.nombre = :nombre2")
    List<Cliente> clientesEncontrados(String nombre2);

    List<Cliente>findAllByNombre(String nombre);

    @Query("select c from Cliente c where c.email = ?1 and c.password = ?2")
    Optional<Cliente>clientesEncontrados2(String email, String contraseña);

    Optional<Cliente> findByEmailAndPassword(String email, String password);

    Page<Cliente> findAll(Pageable pageable);

    @Query("select c.email, e from Cliente c left join c.comentarios e")
    List<Object[]> emailComentariosUsuario();

    @Query("select distinct t from Cliente c join c.telefonos t")
    List<String> obtenerUsuariosTelefono();

}
