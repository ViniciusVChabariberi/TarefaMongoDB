package com.vinicius.controller.dto.response;

import java.util.List;

public record LoginResponse (
        String id,
        String username,
        String password,
        List<String> roles
){
}
