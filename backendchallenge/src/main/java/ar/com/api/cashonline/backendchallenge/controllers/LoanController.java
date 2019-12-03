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

import ar.com.api.cashonline.backendchallenge.entities.Loan;
import ar.com.api.cashonline.backendchallenge.excepciones.LoanException;
import ar.com.api.cashonline.backendchallenge.models.request.RegistrationLoanRequest;
import ar.com.api.cashonline.backendchallenge.models.response.LoansResponse;
import ar.com.api.cashonline.backendchallenge.models.response.UsuarioandLoansResponse;
import ar.com.api.cashonline.backendchallenge.services.LoanService;
@RestController
public class LoanController {
    @Autowired
    LoanService ls;

    @PostMapping("/loans")
    public UsuarioandLoansResponse postNewLoan(@RequestBody RegistrationLoanRequest req)
            throws LoanException, UserException {
        UsuarioandLoansResponse r = new UsuarioandLoansResponse();

        int prestamoCreadoId = ls.createLoan(req.userId, req.totalLoan, req.cantLoan, req.loanAmount);
        r.isOk = true;
        r.message = "Prestamo generado";
        r.prestamoCreadoId = prestamoCreadoId;

        return r;

    }



    @GetMapping("/loans/{id}")
    public Loan getPrestamoById(@PathVariable int id) {

        Loan l = ls.buscarPorId(id);

        return l;
    }

    @GetMapping("/loans")
    public LoansResponse getPrestamoByUsuarioId(@RequestParam(value = "user_id", required = false) @PathVariable int userId,
            @RequestParam(value = "page", required = true) int page,
            @RequestParam(value = "size", required = true) int size) {

        LoansResponse r = new LoansResponse();

        List<Loan> loans = new ArrayList<Loan>();

        int offset = (page - 1) * size + 1;

        if (userId == 0) {
            loans = ls.listloans(size, offset);
            r.paging.total = ls.contar();
        } else {
            loans = ls.buscarPorUsuarioId(userId, size, offset);
            r.paging.total = ls.contar();
        }

        r.items=loans;
        r.paging.page=page;
        r.paging.size=size;
        return r;
    }

}