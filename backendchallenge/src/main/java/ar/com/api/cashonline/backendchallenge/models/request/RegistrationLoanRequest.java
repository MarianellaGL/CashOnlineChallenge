package ar.com.api.cashonline.backendchallenge.models.request;

import java.math.BigDecimal;
import java.util.Date;

import ar.com.api.cashonline.backendchallenge.entities.Usuario;

public class RegistrationLoanRequest {

    public int usuarioId;

    public BigDecimal totalPrestamo; 
    public Integer cantCuotas; 
    public BigDecimal montoCuotas; 


    
}