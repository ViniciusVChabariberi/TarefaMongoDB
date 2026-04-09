package com.vinicius.controller;

import com.vinicius.controller.adapter.LoginControllerAdapter;
import com.vinicius.controller.dto.request.LoginRequest;
import com.vinicius.controller.dto.response.LoginResponse;
import com.vinicius.model.Login;
import com.vinicius.repository.LoginRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logins")
public class LoginController {

    public final LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    @PostMapping
    public LoginResponse salvar(@RequestBody LoginRequest request){

        Login login = LoginControllerAdapter.castRequest(request);

        Login loginSalvo = loginRepository.salve(login);

        return LoginControllerAdapter.castResponse(loginSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoginResponse> atualizar(@PathVariable String id, @RequestBody LoginRequest request) {

        Login loginExistente = loginRepository.findById(id);
        if (loginExistente == null) {
            return ResponseEntity.notFound().build();
        }

        Login loginParaAtualizar = LoginControllerAdapter.castRequest(id, request);

        Login loginAtualizado = loginRepository.update(loginParaAtualizar);

        return ResponseEntity.ok(LoginControllerAdapter.castResponse(loginAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id){

        Login loginExistente = loginRepository.findById(id);

        if (loginExistente == null) {
            return ResponseEntity.notFound().build();
        }

        loginRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public String login(){
        return "Realizar Login";
    }

}
