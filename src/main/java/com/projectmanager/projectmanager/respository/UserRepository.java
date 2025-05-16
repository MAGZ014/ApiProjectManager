package com.projectmanager.projectmanager.respository;

import com.projectmanager.projectmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

    //Busqueda por email
    User findByEmail(String email);
}
