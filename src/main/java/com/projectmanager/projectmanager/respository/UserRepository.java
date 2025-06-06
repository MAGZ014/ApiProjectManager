package com.projectmanager.projectmanager.respository;

import com.projectmanager.projectmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{

    //Busqueda por email
    Optional<User> findByEmail(String email);
}
