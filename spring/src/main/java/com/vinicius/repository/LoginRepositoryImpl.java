package com.vinicius.repository;

import com.vinicius.model.Login;
import com.vinicius.repository.adapter.LoginRepositoryAdapter;
import com.vinicius.repository.mongo.LoginRepositoryWithMongoDB;
import com.vinicius.repository.orm.LoginOrmMongo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LoginRepositoryImpl implements LoginRepository{
    private final PasswordEncoder encoder;
    private final LoginRepositoryWithMongoDB repository;

    public LoginRepositoryImpl(PasswordEncoder encoder, LoginRepositoryWithMongoDB repository){
        this.encoder = encoder;
        this.repository = repository;
    }

    @Override
    public Login salve(Login login){
        LoginOrmMongo orm = LoginRepositoryAdapter.castEntity(login);
        LoginOrmMongo ormSave = repository.save(orm);
        return LoginRepositoryAdapter.castOrm(ormSave, encoder);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Login update(Login login) {
        LoginOrmMongo orm = LoginRepositoryAdapter.castEntity(login);
        LoginOrmMongo ormSave = repository.save(orm);
        return LoginRepositoryAdapter.castOrm(ormSave, encoder);
    }

    @Override
    public Login findById(String id) {
        LoginOrmMongo orm = repository.findById(id).orElse(null);
        return orm != null ? LoginRepositoryAdapter.castOrm(orm, encoder) : null;
    }

    @Override
    public Login findByUsername(String username) {
        try {
            Optional<LoginOrmMongo> optional = repository.findByUsername(username);
            if (optional.isEmpty()) {
                throw new UsernameNotFoundException("Usuario não encontrado");
            }
            return LoginRepositoryAdapter.castOrm(optional.get(), encoder);
        } catch (UsernameNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
