package com.adjebbi.account.web;

import com.adjebbi.account.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity getUser(@PathVariable String id){
        return ResponseEntity.ok(userService.getUserInformation(id).get());
    }
}
