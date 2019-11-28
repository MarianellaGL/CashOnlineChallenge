package ar.com.api.cashonline.backendchallenge.controllers;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.api.cashonline.backendchallenge.excepciones.UserEdadException;
import ar.com.api.cashonline.backendchallenge.models.request.RegistrationRequest;
import ar.com.api.cashonline.backendchallenge.models.response.RegistrationResponse;

import ar.com.api.cashonline.backendchallenge.services.UsuarioService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usService;

    @PostMapping("/usuarios/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req)
            throws UserEdadException, UserException {
        RegistrationResponse r = new RegistrationResponse();

        int usuarioCreadoId = usService.crearUsuario(req.firstName, req.lastName, req.email, req.dni, req.edad);
        r.isOk = true;
        r.message = "usuario registrado con éxito.";
        r.usuarioId = usuarioCreadoId;

        return r;

    }

//@DeleteMapping("/usuarios/{id}")



}
