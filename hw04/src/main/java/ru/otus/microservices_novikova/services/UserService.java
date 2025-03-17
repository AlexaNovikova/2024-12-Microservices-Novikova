package ru.otus.microservices_novikova.services;

import ru.otus.microservices_novikova.entities.User;

import java.util.List;

public interface UserService {
    User findById(long userId);

    User createUser(User user);

    User updateUser(User user);

    void deleteUserById(long id);

    List<User> findAll();
}
