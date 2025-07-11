package ru.otus.hw.services;

import ru.otus.hw.models.User;

import java.util.Optional;

public interface UsersService {

    Optional<User> findById(String id);

    User create(String id, String login);

}
