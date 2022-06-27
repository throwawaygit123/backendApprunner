package com.quanbio.login;


import com.quanbio.jwttoken.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @PostMapping("/login")
//    public UserLogin login(@RequestBody UserLogin login) {
//
//        UserLogin user =this.loginRepository.findByEmailAndPassword(login.getEmail(),login.getPassword())
//                .orElseThrow(() -> new RecordNotFoundException("Email and Password do not match ! "));
//
//            return user;
//
//    }

    @PostMapping("/user")
    public Map<String,Object> login(@RequestBody UserLogin user){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            UserLogin login =loginRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
            Map<String,String> payload = new HashMap<>();
            payload.put("id",login.getId()+"");
            payload.put("email",login.getEmail());
            String token = JwtToken.getToken(payload);
            map.put("state",true);
            map.put("msg","Authentication success");
            map.put("token",token);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg",e.toString());
        }
        return map;

    }

}
