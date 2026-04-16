package com.vinicius.controller.adapter;

import com.vinicius.controller.dto.request.LoginRequest;
import com.vinicius.model.Entry;

public class AuthControllerAdapter {
    private AuthControllerAdapter() {
    }

    public static Entry cast(LoginRequest request) {
        return new Entry(request.username(), request.password());
    }
}
