package ar.com.api.cashonline.backendchallenge.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.api.cashonline.backendchallenge.entities.Loan;
import ar.com.api.cashonline.backendchallenge.entities.User;


@Repository
public interface LoanRepository  extends JpaRepository<Loan, Integer>{ 


    Optional<Loan> findById(Integer id);


    public Loan findByUser(User u);
    @Query(value ="SELECT * FROM loan LIMIT ?,?", nativeQuery = true)
    List<Loan> findPrestamos(int offset, int size);
    @Query(value = "SELECT count(*) FROM loan WHERE user_id=? ", nativeQuery = true)
    long countByUserid(Integer userId);
   
    @Query(value = "SELECT * FROM loan WHERE user_id=? LIMIT ?,?", nativeQuery = true)
    public List<Loan> listarPrestamosPorUsuario(Integer userId, int offset, int size);

}


