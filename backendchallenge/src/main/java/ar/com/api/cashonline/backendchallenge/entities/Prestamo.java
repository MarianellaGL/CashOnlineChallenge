package ar.com.api.cashonline.backendchallenge.entities;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Prestamo {

    private int idPrestamo;
    private BigDecimal totalPrestamo;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Integer cantCuotas;
    private BigDecimal montoCuotas;

    public Prestamo(int idPrestamo, BigDecimal totalPrestamo, Usuario usuario, Date fechaPrestamo, Integer cantCuotas,
            BigDecimal montoCuotas) {
        this.idPrestamo = idPrestamo;
        this.totalPrestamo = totalPrestamo;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.cantCuotas = cantCuotas;
        this.montoCuotas = montoCuotas;
    }

    public Prestamo() {
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public BigDecimal getTotalPrestamo() {
        return totalPrestamo;
    }

    public void setTotalPrestamo(BigDecimal totalPrestamo) {
        this.totalPrestamo = totalPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Integer getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(Integer cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public BigDecimal getMontoCuotas() {
        return montoCuotas;
    }

    public void setMontoCuotas(BigDecimal montoCuotas) {
        this.montoCuotas = montoCuotas;
    }

}