package ar.com.api.cashonline.backendchallenge.services;

import java.util.*;
import java.math.*;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.api.cashonline.backendchallenge.entities.Loan;
import ar.com.api.cashonline.backendchallenge.entities.User;
import ar.com.api.cashonline.backendchallenge.repo.LoanRepository;


@Service
public class LoanService {

    @Autowired
    LoanRepository repo;

    @Autowired
    UserService us;

    public void grabar(Loan l) {
        repo.save(l);
    }

    public Loan buscarPorId(int id) {

        Optional<Loan> p = repo.findById(id);

        if (p.isPresent()) {
            return p.get();
        }
        return null;
    }

    public List<Loan> buscarPorUsuarioId(int userId, int size, int offset) {

        return repo.findByUserid(userId, size, offset);
    }

    public List<Loan> listloans(int  size, int offset) {
        return repo.listarPrestamos(size, offset);
    }

    public long contar(){
      return repo.count();

    }


    public int createLoan(int userId, BigDecimal totalLoan, Integer cantLoan, BigDecimal loanAmount
        ) throws UserException {
            
    Date f = new Date();

    User u = us.buscarPorId(userId);

    Loan l =  new Loan();
    l.setLoanDate(f);
    l.setTotalLoan(totalLoan);
    l.setCantLoan(cantLoan);
    l.setLoanAmount(loanAmount);

    u.agregarLoans(l);
    us.grabar(u);

    return l.getLoanId();

    


    }


  

}