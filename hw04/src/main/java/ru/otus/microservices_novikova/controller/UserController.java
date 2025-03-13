package ru.otus.microservices_novikova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.microservices_novikova.entities.User;
import ru.otus.microservices_novikova.services.UserService;

@RestController()
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("user/{userId}")
    public User findUserById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("user/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
