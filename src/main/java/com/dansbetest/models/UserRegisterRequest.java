package com.dansbetest.models;

import java.io.Serializable;

public class UserRegisterRequest implements Serializable {
    public String username;
    public String password;
    public String passwordValidate;
    public String email;
}
