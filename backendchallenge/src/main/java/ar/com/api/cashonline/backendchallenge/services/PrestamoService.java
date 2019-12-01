package ar.com.api.cashonline.backendchallenge.services;

import java.util.*;
import java.math.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.cashonline.backendchallenge.entities.Prestamo;
import ar.com.api.cashonline.backendchallenge.entities.Usuario;
import ar.com.api.cashonline.backendchallenge.repo.PrestamoRepository;


@Service
public class PrestamoService {

    @Autowired
    PrestamoRepository repo;

    public void grabar(Prestamo p) {
        repo.save(p);
    }

    public Prestamo buscarPorId(int id) {

        Optional<Prestamo> p = repo.findById(id);

        if (p.isPresent()) {
            return p.get();
        }
        return null;
    }

    public Prestamo buscarPorUsuario(Usuario u) {

        return repo.findByUsuario(u);
    }

    public List<Prestamo> listloans() {
        return repo.findAll();
    }

    
   public Prestamo bajaPrestamo(int id){

    Prestamo p = this.buscarPorId(id);
  

    repo.save(p);

    return p;
}

public int crearPrestamo( BigDecimal totalPrestamo, Integer cantCuotas, BigDecimal montoCuotas, Date fechaPrestamo){

    Prestamo p =  new Prestamo();
    p.setTotalPrestamo(totalPrestamo);
    p.setCantCuotas(cantCuotas);
    p.setMontoCuotas(montoCuotas);
    
    

    Date f = new Date();

    p.setFechaPrestamo(f);

    return p.getIdPrestamo();

    


    }


  

}