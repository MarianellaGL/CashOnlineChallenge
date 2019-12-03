package ar.com.api.cashonline.backendchallenge.services;

import java.util.*;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.cashonline.backendchallenge.entities.User;

import ar.com.api.cashonline.backendchallenge.excepciones.UserEdadException;
import ar.com.api.cashonline.backendchallenge.repo.UserRepository;


@Service
public class UserService {

    @Autowired
    UserRepository repo;


    public User buscarPorId(int id) {

        return repo.findById(id);
    }

    public void grabar(User u) throws UserException {
        /**
         * UsuarioValidationType r = this.verificarUsuario(u);
         * 
         * if (r != UsuarioValidationType.USUARIO_OK) throw new UsuarioException(r);
         */

        repo.save(u);

    }

    public int createUser(String firstName, String lastName, String email, String dni, int age)
            throws UserException, UserEdadException {
        User u = new User();

        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setDni(dni);
        u.setAge(age);

        repo.save(u);
    
        return u.getUserId();


    }

    public List<User> getUsuarios() {

        return repo.findAll();
    }

   public User bajaUsuario(int id){

        User u = this.buscarPorId(id);       
      

        repo.delete(u);

        return u;
    }


public enum UserValidationType {
        
    User_OK,
    firstName_INVALIDO,
    EDAD_INVALIDO, 
    DNI_INVALIDO,

    USER_DATOS_INVALIDOS
    
}



public UserValidationType verifyUser(User user) {

    if (user.getFirstName() == null)
        return  UserValidationType.USER_DATOS_INVALIDOS;

    if (user.getAge() == 0)
        return UserValidationType.USER_DATOS_INVALIDOS;

    if (user.getDni() == null)
        return UserValidationType.USER_DATOS_INVALIDOS;




return UserValidationType.User_OK;
}
}