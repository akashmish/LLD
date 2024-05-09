package com.restproject.store.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restproject.store.entity.Users;
import com.restproject.store.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController  
@RequestMapping("/api/user") 
public class UserController {
    
    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<?> registerNewUser(@RequestBody Users user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping("")
    public ResponseEntity<?> listAllUsers() {
        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getMethodName(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }
    
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Integer userId, @RequestBody Users user) {
        Users newUser= userService.update(user);
        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }   

    @DeleteMapping("/{userId}")
    public ResponseEntity<Users> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 
}
