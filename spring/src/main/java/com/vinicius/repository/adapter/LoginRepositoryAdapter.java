package com.vinicius.repository.adapter;

import com.vinicius.model.Login;
import com.vinicius.repository.orm.LoginOrmMongo;

public class LoginRepositoryAdapter {
    private LoginRepositoryAdapter(){
    }

    public static Login castOrm(LoginOrmMongo orm){
        return new Login(
                orm.id(),
                orm.username(),
                orm.password(),
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
