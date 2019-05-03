package golf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import golf.model.Account;
import golf.service.AccountService;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

}