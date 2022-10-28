package com.quanbio.mapper;


import com.quanbio.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<UserLogin, Long> {
//    public Optional<UserLogin> findByEmailAndPassword(String email, String password);

    UserLogin findByEmailAndPassword(String email, String password);


}
