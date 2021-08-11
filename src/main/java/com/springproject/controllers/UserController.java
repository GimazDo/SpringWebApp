package com.springproject.controllers;

import com.springproject.entities.User;
import com.springproject.entities.Role;
import com.springproject.repos.RoleRepository;
import com.springproject.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("admin/addRole")
    public String showPageAddRole()
    {
        return "role/addRole";
    }

    @PostMapping("admin/addRole")
    public String addRole(@RequestParam String name)
    {
        Role role = new Role(name);
        roleRepository.save(role);
        return "home";
    }
    @GetMapping("admin/user/addRole")
    public String showPageUserAddNewRole(Model model)
    {
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "user/addUserNewRole";
    }

    @Transactional
    @PostMapping("admin/user/addRole")
    public String UserAddNewRole(@RequestParam String username,
                                 @RequestParam String roleName)
    {
        Role role = roleRepository.findByName(roleName);
        User user  = userRepository.findByUsername(username);
        if(user.getRoles().contains(role)){

            return "user/addUserNewRole";}
        user.addRole(role);
        return "home";
    }

    @GetMapping("admin/user/add")
    public String showPageUserAdd()
    {
        return "user/addUser";
    }

    @PostMapping("/user/add")
    @Transactional
    public String addUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email
    ){
        Role role = roleRepository.findByName("ROLE_USER");
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(role);
        User user = new User(username,passwordEncoder.encode(password),email,roles);
        userRepository.save(user);
        return "home";
    }
    @GetMapping("profile")
    public String showProfile(Model model, Principal principal)
    {
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("username",user.getUsername());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("roles",user.rolesToString());
        return "userProfile";
    }



}
