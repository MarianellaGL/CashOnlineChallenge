package ar.com.api.cashonline.backendchallenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.api.cashonline.backendchallenge.entities.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{ 

    
    Usuario findById (int id);
    Usuario findByFirstName (String firstName);
    Usuario findByDni (int dni);

    

}
