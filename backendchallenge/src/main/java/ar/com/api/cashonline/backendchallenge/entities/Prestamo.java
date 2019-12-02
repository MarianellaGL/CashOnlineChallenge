package ar.com.api.cashonline.backendchallenge.entities;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "prestamo")
@NamedNativeQuery(name = "Prestamo.findByUsuarioid", query ="SELECT * FROM prestamo WHERE usuario_id = ? LIMIT ?, ?" )
@NamedNativeQuery(name = "Prestamo.listarPrestamos", query = "SELECT * FROM prestamo LIMIT ?,?") //LIMIT (Comienzo=offset),(Longitud=size)
public class Prestamo {

    @Id
    @Column(name = "id_prestamo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrestamo;

    @Column(name = "total_prestamo")
    private BigDecimal totalPrestamo = new BigDecimal(0);
    @Column(name = "fecha_prestamo")
    private Date fechaPrestamo;
    @Column(name = "cant_cuotas")
    private Integer cantCuotas;

    @Column(name = "monto_cuotas")
    private BigDecimal montoCuotas = new BigDecimal (0);

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;


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