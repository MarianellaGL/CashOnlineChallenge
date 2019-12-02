package ar.com.api.cashonline.backendchallenge.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.api.cashonline.backendchallenge.entities.Prestamo;
import ar.com.api.cashonline.backendchallenge.entities.Usuario;

@Repository
public interface PrestamoRepository  extends JpaRepository<Prestamo, Integer>{ 


    Optional<Prestamo> findById(Integer id);


    public Prestamo findByUsuario(Usuario u);
    @Query(value ="SELECT * FROM prestamo LIMIT ?,?", nativeQuery = true)
    List<Prestamo> findPrestamo(int offset, int size);
    @Query(value = "SELECT count(*) FROM prestamo WHERE usuario_id = ? ", nativeQuery = true)
    List<Prestamo> findByUsuarioid(int usuarioId,int offset, int size);
    @Query(value = "SELECT * FROM prestamo WHERE usuario_id = ? LIMIT ?,?", nativeQuery = true)
    public List<Prestamo> listarPrestamos(int offset, int size);

}







