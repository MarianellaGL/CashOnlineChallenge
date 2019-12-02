package ar.com.api.cashonline.backendchallenge.controllers;

import java.util.*;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.api.cashonline.backendchallenge.entities.Prestamo;
import ar.com.api.cashonline.backendchallenge.excepciones.LoanException;
import ar.com.api.cashonline.backendchallenge.models.request.RegistrationLoanRequest;
import ar.com.api.cashonline.backendchallenge.models.response.LoansResponse;
import ar.com.api.cashonline.backendchallenge.models.response.UsuarioandLoansResponse;
import ar.com.api.cashonline.backendchallenge.services.PrestamoService;
@RestController
public class LoanController {
    @Autowired
    PrestamoService ps;

    @PostMapping("/loans")
    public UsuarioandLoansResponse postNewLoan(@RequestBody RegistrationLoanRequest req)
            throws LoanException, UserException {
        UsuarioandLoansResponse r = new UsuarioandLoansResponse();

        int prestamoCreadoId = ps.crearPrestamo(req.usuarioId, req.totalPrestamo, req.cantCuotas, req.montoCuotas);
        r.isOk = true;
        r.message = "Prestamo generado";
        r.prestamoCreadoId = prestamoCreadoId;

        return r;

    }

    /**
     * GET /loans?page=1&size=50 /loans?page=1&size=50&user_id=2
     */

    @GetMapping("/loans/{id}")
    public Prestamo getPrestamoById(@PathVariable int id) {

        Prestamo p = ps.buscarPorId(id);

        return p;
    }

    @GetMapping("/loans")
    public LoansResponse getPrestamoByUsuarioId(@RequestParam(value = "usuario_id", required = false) int usuarioId,
            @RequestParam(value = "page", required = true) int page,
            @RequestParam(value = "size", required = true) int size) {

        LoansResponse r = new LoansResponse();

        List<Prestamo> loans = new ArrayList<Prestamo>();

        int offset = (page - 1) * size + 1;

        if (usuarioId == 0) {
            loans = ps.listloans(size, offset);
            r.paging.total = ps.contar();
        } else {
            loans = ps.buscarPorUsuarioId(usuarioId, size, offset);
            r.paging.total = ps.contar();
        }

        r.items=loans;
        r.paging.page=page;
        r.paging.size=size;
        return r;
    }

}