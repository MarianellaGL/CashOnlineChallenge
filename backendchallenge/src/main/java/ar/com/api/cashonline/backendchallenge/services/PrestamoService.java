package ar.com.api.cashonline.backendchallenge.services;

import java.util.*;
import java.math.*;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.cashonline.backendchallenge.entities.Prestamo;
import ar.com.api.cashonline.backendchallenge.entities.Usuario;
import ar.com.api.cashonline.backendchallenge.repo.PrestamoRepository;

@Service
public class PrestamoService {

    @Autowired
    PrestamoRepository repo;

    @Autowired
    UsuarioService us;

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

    public List<Prestamo> buscarPorUsuarioId(int usuarioId, int size, int offset) {

        return repo.findByUsuarioid(usuarioId, size, offset);
    }

    public List<Prestamo> listloans(int  size, int offset) {
        return repo.listarPrestamos(size, offset);
    }


    public int crearPrestamo(int usuarioId, BigDecimal totalPrestamo, Integer cantCuotas, BigDecimal montoCuotas
        ) throws UserException {
    Date f = new Date();

    Usuario u = us.buscarPorId(usuarioId);

    Prestamo p =  new Prestamo();
    p.setFechaPrestamo(f);
    p.setTotalPrestamo(totalPrestamo);
    p.setCantCuotas(cantCuotas);
    p.setMontoCuotas(montoCuotas);

    u.agregarPrestamo(p);
    us.grabar(u);

    return p.getIdPrestamo();

    


    }


  

}