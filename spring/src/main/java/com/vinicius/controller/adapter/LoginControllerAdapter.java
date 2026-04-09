package com.vinicius.controller.adapter;

import com.vinicius.controller.dto.request.LoginRequest;
import com.vinicius.controller.dto.response.LoginResponse;
import com.vinicius.model.Login;

import java.util.UUID;

public class LoginControllerAdapter {
    private LoginControllerAdapter(){
    }

    public static Login castRequest(LoginRequest request){
        return new Login(
                UUID.randomUUID().toString(),
                request.username(),
                request.password(),
                request.roles()
        );
    }

    public static Login castRequest(String id, LoginRequest request){
        return new Login(
                id,
                request.username(),
                request.password(),
                request.roles()
        );
    }

    public static LoginResponse castResponse(Login login) {
        return new LoginResponse(
                login.id(),
                login.username(),
                login.password(),
                login.roles()
        );
    }
}
