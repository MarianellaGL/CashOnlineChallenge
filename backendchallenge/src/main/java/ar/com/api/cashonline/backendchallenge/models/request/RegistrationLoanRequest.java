package ar.com.api.cashonline.backendchallenge.models.request;

import java.math.BigDecimal;
import java.util.Date;

import ar.com.api.cashonline.backendchallenge.entities.Usuario;

public class RegistrationLoanRequest {

    public Usuario usuario;

    public BigDecimal totalPrestamo; 
    public Integer cantCuotas; 
    public BigDecimal montoCuotas; 
    public Date fechaPrestamo;


    
}