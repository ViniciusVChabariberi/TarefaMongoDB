package com.vinicius.config;

import com.vinicius.repository.LoginRepository;
import com.vinicius.repository.LoginRepositoryImpl;
import com.vinicius.repository.mongo.LoginRepositoryWithMongoDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class RepositoryConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Primary
    public LoginRepository loginRepository(LoginRepositoryWithMongoDB repository){
        return new LoginRepositoryImpl(passwordEncoder(), repository);
    }
}
