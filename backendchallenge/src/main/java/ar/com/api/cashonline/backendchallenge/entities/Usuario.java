package ar.com.api.cashonline.backendchallenge.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "empleado_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int usuarioId;
    private String email;
    private String firstName;
    private String lastName;
    private String dni;
    private int edad;
    private Map<Integer, Prestamo> loans = new HashMap<Integer, Prestamo>();

    public Usuario(int usuarioId, String email, String firstName, String lastName, String dni, int edad,
            Map<Integer, Prestamo> loans) {
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

    public Map<Integer, Prestamo> getLoans() {
        return loans;
    }

    public void setLoans(Map<Integer, Prestamo> loans) {
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

}