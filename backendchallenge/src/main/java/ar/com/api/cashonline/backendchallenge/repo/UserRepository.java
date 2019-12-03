package ar.com.api.cashonline.backendchallenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.api.cashonline.backendchallenge.entities.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{ 

    
    User findById (int id);
    User findByFirstName (String firstName);
    User findByDni (int dni);

    

}
