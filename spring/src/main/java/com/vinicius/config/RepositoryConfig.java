package com.vinicius.config;

import com.vinicius.repository.LoginRepository;
import com.vinicius.repository.LoginRepositoryImpl;
import com.vinicius.repository.mongo.LoginRepositoryWithMongoDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean
    public LoginRepository loginRepository(LoginRepositoryWithMongoDB repository){
        return new LoginRepositoryImpl(repository);
    }
}
