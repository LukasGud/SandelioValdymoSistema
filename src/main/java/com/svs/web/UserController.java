package com.svs.web;

import com.svs.domain.User;
import com.svs.services.MapValidationErrorServices;
import com.svs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapValidationErrorServices mapValidationErrorServices;

    @PostMapping("")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorServices.MapValidationService(result);
        if (errorMap != null) return errorMap;

        User user1 = userService.saveOrUpdate(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

}
