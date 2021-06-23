package com.joseph.synopsis.controller;


import com.joseph.synopsis.Model.User;
import com.joseph.synopsis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User userCreated = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);

    }

    @PutMapping(value="/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        User userInDB = userService.updateUser(user);
        if(userInDB==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userInDB);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        User userDeleted = userService.getUser(id);
        if(userDeleted==null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(id);
        return ResponseEntity.ok(userDeleted);
    }

}