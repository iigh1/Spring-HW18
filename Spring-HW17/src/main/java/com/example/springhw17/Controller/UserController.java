package com.example.springhw17.Controller;

import com.example.springhw17.Model.User;
import com.example.springhw17.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getAllCoffee() {
        List<User> userList = userService.getAllCoffee();
        return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user, @PathVariable Integer id, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
        boolean isUpdated = userService.updateUser(id, user);
        if (isUpdated) {
            return ResponseEntity.status(200).body("user updated");

        }
        return ResponseEntity.status(400).body("not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {

        boolean isDeleted = userService.deleteUser(id);

        if (isDeleted) {
            return ResponseEntity.status(200).body("user deleted");
        }
        return ResponseEntity.status(400).body("not found");
    }

    @GetMapping("/get1/{username}/{password}")
    public ResponseEntity getUserByUserName(@PathVariable String username, @PathVariable String password) {

        User user = userService.getUserByUserName(username, password);

        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/get3/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email) {

        User user = userService.getUserByEmail(email);

        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/get4/{role}")
    public ResponseEntity getUserByRole(@PathVariable String role) {
        List<User> users = userService.getUserByRole(role);

        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/get5/{age}")
    public ResponseEntity getUserByAge(@PathVariable Integer age) {
        List<User> users = userService.getUserByAge(age);

        return ResponseEntity.status(200).body(users);
    }
}