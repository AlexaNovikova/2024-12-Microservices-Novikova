package ru.otus.hw.services;

import ru.otus.hw.models.User;

import java.util.Optional;

public interface UsersService {

    Optional<User> findByLoginPassword(String login, String password);

    User create(User authUser);

}
