package com.quanbio.test;

import com.quanbio.model.User;
import com.quanbio.service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@AutoConfigureMockMvc
@SpringBootTest
public class Test {
    @Autowired
    private AccountService accountService;

//    @org.junit.Test
//    public void testAccount(){
//        User user1 = new User();
//        user1.setEmail("zhangsan");
//        user1.setPassword("zhangsan");
//        user1.setId(3);
//        user1.setRoleid("1");
//        accountService.addAccount(user1);
////        accountService.save(user1);
//    }
}
