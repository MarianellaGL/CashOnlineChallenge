package ar.com.api.cashonline.backendchallenge.entities;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int usuarioId;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Prestamo> loans = new ArrayList<Prestamo>();

    private String email;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String dni;
    private int edad;
    

    public Usuario(int usuarioId, String email, String firstName, String lastName, String dni, int edad,
            List<Prestamo> loans) {
        this.usuarioId = usuarioId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.edad = edad;
        this.loans = loans;
    }

    

    public Usuario() {
    }

    public int getId() {
        return usuarioId;
    }

    public void setId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Prestamo> getLoans() {
        return loans;
    }

    public void setLoans(List<Prestamo> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "El usuario [firstName=" + firstName + ", usuarioId=" + usuarioId + ", lastName=" + lastName
                + " tiene loans=" + loans + "] pendientes";
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setPrestamo(List<Prestamo> loans) {
        this.loans = loans;
    }

    public List<Prestamo> getPrestamo(List<Prestamo> loans) {
        return loans;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamo.setUsuario(this);
        this.loans.add(prestamo);

    }

    



}