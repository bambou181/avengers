package com.gestion.esatic.data;

import com.gestion.esatic.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
