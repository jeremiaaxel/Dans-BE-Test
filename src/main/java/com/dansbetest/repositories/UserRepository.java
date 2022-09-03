package com.dansbetest.repositories;

import com.dansbetest.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAllByUsername(String username);
}
