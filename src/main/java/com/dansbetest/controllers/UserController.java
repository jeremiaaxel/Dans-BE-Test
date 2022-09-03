package com.dansbetest.controllers;

import com.dansbetest.models.User;
import com.dansbetest.models.UserLoginRequest;
import com.dansbetest.models.UserRegisterRequest;
import com.dansbetest.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService _userSvc;

    @Autowired
    public UserController(IUserService userService) {
        this._userSvc = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "Test";
    }

    @GetMapping("/")
    public List<User> getAllUser() {
        return _userSvc.getAll();
    }

    @PostMapping("/register")
    public boolean register(@RequestBody UserRegisterRequest request) {
        if (request.username.equals("")) return false;
        if (request.password.equals("")) return false;
        if (!request.password.equals(request.passwordValidate)) return false;
        if (request.email.equals("")) return false;

        User newUser = _userSvc.createNewUser(request.username, request.password, request.email);
        if (newUser == null) return false;
        return true;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserLoginRequest request) {
        if (request.username.equals("")) return false;
        if (request.password.equals("")) return false;

        boolean loginStatus = _userSvc.login(request.username, request.password);
        return loginStatus;
    }
}
