package com.springproject.controllers;

import com.springproject.entities.Account;
import com.springproject.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/account")
    public String account(Model model) {
        Iterable<Account> accounts = accountRepository.findAll();
        model.addAttribute("accounts", accounts);
        model.addAttribute("title", "Личный кабинет");
        return "accountsList";
    }
    @GetMapping("/account/add")
    public String accountAdd(Model model) {

        return "accountAdd";
    }
    @PostMapping("/account/add")
    public String accoundAddDB(@RequestParam String firstName,
                               @RequestParam String surName,
                               @RequestParam String lastName,
                               @RequestParam String info, Model model)
    {
        Account account = new Account(firstName,surName,lastName,info);
        accountRepository.save(account);
        return "home";
    }
}
