package com.project.payrolldanpph21.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payrolldanpph21.models.Login;
import com.project.payrolldanpph21.repositories.LoginRepository;


@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    
    public void save(Login login) {
        loginRepository.save(login);
    }

    public Login login(String username, String password) {
        List <Login> login = loginRepository.findByUsernameAndPassword(username, password);
        return login.stream().findFirst().orElse(null);
    }
}
