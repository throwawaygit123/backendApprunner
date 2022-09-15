package com.quanbio.controller;

import com.quanbio.model.User;
import com.quanbio.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("add")
    public void add(User user) {
        accountService.addAccount(user);
    }

}
