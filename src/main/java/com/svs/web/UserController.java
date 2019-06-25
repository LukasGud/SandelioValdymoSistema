package com.svs.web;

import com.svs.domain.User;
import com.svs.services.MapValidationErrorServices;
import com.svs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
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

    @GetMapping("/{firstName}")
    public ResponseEntity<?> getUserByFullName(@PathVariable String firstName) {
        User user = userService.findByFullName(firstName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.findallUsers();
    }

    @DeleteMapping("/{firstName}")
    public ResponseEntity<?> deleteUser(@PathVariable String firstName) {
        userService.deleteUserByFirstName(firstName);
        return new ResponseEntity<>("User with name '" + firstName + "'was deleted", HttpStatus.OK);
    }



}
