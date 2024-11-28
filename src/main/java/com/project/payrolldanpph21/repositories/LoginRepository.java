package com.project.payrolldanpph21.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.payrolldanpph21.models.Login;

public interface LoginRepository extends JpaRepository<Login,String>{
    List <Login> findByUsernameAndPassword(String username, String password);

}
