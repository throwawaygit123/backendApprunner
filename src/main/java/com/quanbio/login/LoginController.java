package com.quanbio.login;


import com.quanbio.device.Device;
import com.quanbio.exceptionHandler.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/userlogin")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository  ;


    @GetMapping
    public List<UserLogin> getLogin() {
        return this.loginRepository.findAll();
    }

    @PostMapping
    public UserLogin addLogin(@RequestBody UserLogin login) {
        return this.loginRepository.save(login);
    }

    @PostMapping("/login")
    public UserLogin login(@RequestBody UserLogin login) {

        UserLogin user =this.loginRepository.findByEmailAndPassword(login.getEmail(),login.getPassword())
                .orElseThrow(() -> new RecordNotFoundException("Email and Password do not match ! "));

            return user;

    }

}
