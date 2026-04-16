package com.vinicius.repository.adapter;

import com.vinicius.model.Login;
import com.vinicius.repository.orm.LoginOrmMongo;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginRepositoryAdapter {
    private LoginRepositoryAdapter(){
    }

    public static Login castOrm(LoginOrmMongo orm, PasswordEncoder passwordEncoder){
        return new Login(
                orm.id(),
                orm.username(),
                passwordEncoder.encode(orm.password()),
                orm.roles()
        );
    }

    public static LoginOrmMongo castEntity(Login entity){
        return new LoginOrmMongo(
                entity.id(),
                entity.username(),
                entity.password(),
                entity.roles()
        );
    }
}
