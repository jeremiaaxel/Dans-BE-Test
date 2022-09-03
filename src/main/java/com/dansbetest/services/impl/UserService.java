package com.dansbetest.services.impl;

import com.dansbetest.repositories.UserRepository;
import com.dansbetest.models.User;
import com.dansbetest.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findAllByUsername(username).get(0);
    }

    @Override
    public User createNewUser(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userRepository.save(user);

        return user;
    }

    @Override
    public boolean login(String username, String password) {
        List<User> users = userRepository.findAllByUsername(username);
        if (users.isEmpty()) return false;
        User user = users.get(0);
        if (user == null) return false;

        return user.getPassword().equals(password);
//        if (!passwordEncoder.matches(password, user.getPassword())) return false;
//        return true;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }
}
