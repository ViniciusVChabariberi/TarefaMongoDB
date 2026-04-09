package com.vinicius.repository;

import com.vinicius.model.Login;

public interface LoginRepository {
    Login salve(Login login);
    void delete(String id);
    Login update(Login login);
    Login findById(String id);
}
