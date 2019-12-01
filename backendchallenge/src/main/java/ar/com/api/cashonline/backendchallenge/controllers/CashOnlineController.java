package ar.com.api.cashonline.backendchallenge.controllers;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.api.cashonline.backendchallenge.entities.Prestamo;
import ar.com.api.cashonline.backendchallenge.entities.Usuario;
import ar.com.api.cashonline.backendchallenge.excepciones.LoanException;
import ar.com.api.cashonline.backendchallenge.excepciones.UserEdadException;
import ar.com.api.cashonline.backendchallenge.models.request.RegistrationLoanRequest;
import ar.com.api.cashonline.backendchallenge.models.request.RegistrationRequest;
import ar.com.api.cashonline.backendchallenge.models.response.RegistrationResponse;
import ar.com.api.cashonline.backendchallenge.models.response.UsuarioandLoansResponse;
import ar.com.api.cashonline.backendchallenge.services.PrestamoService;
import ar.com.api.cashonline.backendchallenge.services.UsuarioService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class CashOnlineController {

    @Autowired
    UsuarioService usService;
    @Autowired
    PrestamoService ps;

    @PostMapping("/auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req)
            throws UserEdadException, UserException {
        RegistrationResponse r = new RegistrationResponse();

        int usuarioCreadoId = usService.crearUsuario(req.firstName, req.lastName, req.email, req.dni, req.edad);
        r.isOk = true;
        r.message = "usuario registrado con éxito.";
        r.usuarioId = usuarioCreadoId;

        return r;

    }


    @PostMapping("users/{id}/new/loan")
    public UsuarioandLoansResponse postNewLoan(@RequestBody RegistrationLoanRequest req)
            throws LoanException {
                UsuarioandLoansResponse r = new UsuarioandLoansResponse();

        int prestamoCreadoId = ps.crearPrestamo(req.totalPrestamo, req.cantCuotas, req.montoCuotas, req.fechaPrestamo);
        r.isOk = true;
        r.message = "Prestamo Generado";
        r.prestamoCreadoId = prestamoCreadoId;

        return r;

    }


@DeleteMapping("/usuarios/{id}")
public UsuarioandLoansResponse bajaUsuario(@PathVariable int id){
     UsuarioandLoansResponse r = new UsuarioandLoansResponse();

    Usuario u = usService.bajaUsuario(id);

    r.isOk = true;
    r.message = "Usuario " + u.getFirstName() + " dado de baja.";
    r.usuarioId = u.getId();

    return r;
}


@GetMapping("/users/{id}")
public Usuario getUsuarioById(@PathVariable int id){


    Usuario u = usService.buscarPorId(id);

    return u;
}

/**GET /loans?page=1&size=50  /loans?page=1&size=50&user_id=2
 */

@GetMapping("/loans/{id}")
public Prestamo getPrestamoById(@PathVariable int id){


    Prestamo p = ps.buscarPorId(id);

    return p;
}




}
