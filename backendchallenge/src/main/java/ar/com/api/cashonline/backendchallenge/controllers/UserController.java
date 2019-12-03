package ar.com.api.cashonline.backendchallenge.controllers;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.api.cashonline.backendchallenge.entities.User;
import ar.com.api.cashonline.backendchallenge.excepciones.UserEdadException;
import ar.com.api.cashonline.backendchallenge.models.request.RegistrationLoanRequest;
import ar.com.api.cashonline.backendchallenge.models.request.RegistrationRequest;
import ar.com.api.cashonline.backendchallenge.models.response.RegistrationResponse;
import ar.com.api.cashonline.backendchallenge.models.response.UsuarioandLoansResponse;
import ar.com.api.cashonline.backendchallenge.services.LoanService;
import ar.com.api.cashonline.backendchallenge.services.UserService;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {

    @Autowired
    UserService usService;
    @Autowired
    LoanService ls;

    @PostMapping("/auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req)
            throws UserEdadException, UserException {
        RegistrationResponse r = new RegistrationResponse();

        int usuarioCreadoId = usService.createUser(req.firstName, req.lastName, req.email, req.dni, req.age);
        r.isOk = true;
        r.message = "usuario registrado con éxito.";
        r.userId = usuarioCreadoId;

        return r;

    }

   
     //lo de abajo es en un repo
    //select count from tabla where user id =:?(no es asi tal cual)
    //long contarporusuario(usuario)
    //declaras en el service el public long contaregistros: repo.count()

    @DeleteMapping("/users/{id}")
    public UsuarioandLoansResponse bajaUsuario(@PathVariable int id) {
        UsuarioandLoansResponse r = new UsuarioandLoansResponse();

        User u = usService.bajaUsuario(id);

        r.isOk = true;
        r.message = "Usuario " + u.getFirstName() + " dado de baja.";
        r.userId = u.getId();

        return r;
    }

    @GetMapping("/users/{id}")
    public User getUsuarioById(@PathVariable int id) {

        User u = usService.buscarPorId(id);

        return u;
    }

}
