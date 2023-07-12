package com.lshh.userserver.controller;

import com.lshh.userserver.model.dto.UserBasic;
import com.lshh.userserver.model.dto.UserRequest;
import com.lshh.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public ResponseEntity test(){
        return new ResponseEntity<>("test OK", HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public Mono<Integer> signUp(@RequestBody UserRequest user){
        return userService.createUser(user);
    }

    @PostMapping("/signIn")
    public Mono<UserBasic> signIn(@RequestBody UserRequest user){
        return userService.findUser(user.getLoginId(), user.getPassword());
    }
}
