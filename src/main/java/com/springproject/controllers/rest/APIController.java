package com.springproject.controllers.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springproject.entities.User;
import com.springproject.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
public class APIController {
    private UserService service;

    @RequestMapping(value="/api/user",method = RequestMethod.POST)
    public String post(@RequestBody String s) throws JsonProcessingException {
       ObjectMapper objectMapper = new ObjectMapper();
       User user = objectMapper.readValue(s,User.class);
        System.out.println("post");
       System.out.println(user.toString());

        return "post";

    }


    @RequestMapping(value="/api/user",method = RequestMethod.GET, produces = "application/json")
    public String get() throws JsonProcessingException {

        System.out.println("get");
        System.out.println();
        return "get";

    }


}