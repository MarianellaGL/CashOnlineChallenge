package ar.com.api.cashonline.backendchallenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.api.cashonline.backendchallenge.entities.Prestamo;
import ar.com.api.cashonline.backendchallenge.entities.Usuario;

@Repository
public interface PrestamoRepository  extends JpaRepository<Prestamo, Integer>{ 


    public Prestamo findByUsuario(Usuario u);
}