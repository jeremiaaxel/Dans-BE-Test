package com.dansbetest.services.interfaces;

import com.dansbetest.models.User;

import java.util.List;

public interface IUserService {
    User getUserByUsername(String username);
    User createNewUser(String username, String password, String email);
    boolean login(String username, String password);
    List<User> getAll();
}
