package ar.com.api.cashonline.backendchallenge.services;

import java.util.*;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.cashonline.backendchallenge.entities.Usuario;
import ar.com.api.cashonline.backendchallenge.excepciones.UserEdadException;
import ar.com.api.cashonline.backendchallenge.repo.UsuarioRepository;
import ar.com.api.cashonline.backendchallenge.services.PrestamoService;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    @Autowired
    PrestamoService ps;

    public Usuario buscarPorId(int id) {

        return repo.findById(id);
    }

    public void grabar(Usuario u) throws UserException {
        /**
         * UsuarioValidationType r = this.verificarUsuario(u);
         * 
         * if (r != UsuarioValidationType.USUARIO_OK) throw new UsuarioException(r);
         */

        repo.save(u);

    }

    public int crearUsuario(String firstName, String lastName, String email, String dni, int edad)
            throws UserException, UserEdadException {
        Usuario u = new Usuario();

        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setDni(dni);
        u.setEdad(edad);

        repo.save(u);
    
        return u.getUsuarioId();


    }

    public List<Usuario> getUsuarios() {

        return repo.findAll();
    }

   public Usuario bajaUsuario(int id){

        Usuario u = this.buscarPorId(id);       
      

        repo.delete(u);

        return u;
    }
//rel tipo cascada

}
