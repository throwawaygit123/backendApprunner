package com.quanbio.login;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<UserLogin, Long> {
    public Optional<UserLogin> findByEmailAndPassword(String email, String password);

}
