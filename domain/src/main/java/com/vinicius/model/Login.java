package com.vinicius.model;

import java.util.List;

public record Login (
    String id,
    String username,
    String password,
    List<String> roles
){
}
