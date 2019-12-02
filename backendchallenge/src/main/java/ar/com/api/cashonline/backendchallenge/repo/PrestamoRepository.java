package ar.com.api.cashonline.backendchallenge.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.api.cashonline.backendchallenge.entities.Prestamo;
import ar.com.api.cashonline.backendchallenge.entities.Usuario;

@Repository
public interface PrestamoRepository  extends JpaRepository<Prestamo, Integer>{ 


    public Prestamo findByUsuario(Usuario u);
    
    public List<Prestamo> findByUsuarioid(int usuarioId,int offset, int size);
    public List<Prestamo> listarPrestamos(int offset, int size);

}