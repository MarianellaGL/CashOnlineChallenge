package ar.com.api.cashonline.backendchallenge.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.api.cashonline.backendchallenge.entities.Prestamo;
import ar.com.api.cashonline.backendchallenge.entities.Usuario;
import ar.com.api.cashonline.backendchallenge.repo.PrestamoRepository;

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


  

}