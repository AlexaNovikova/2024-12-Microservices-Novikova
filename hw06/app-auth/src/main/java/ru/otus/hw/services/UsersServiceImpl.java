package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.exceptions.EntityNotFoundException;
import ru.otus.hw.models.User;
import ru.otus.hw.repositories.UserRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    public Optional<User> findByLoginPassword(String login, String password) {
        var user = userRepository.findByLoginAndPassword(login, password);

        if (user==null) {
            throw new EntityNotFoundException("User with login %s not found".formatted(login));
        }
         return Optional.of(user);
    }

    @Override
    @Transactional
    public User create(User authUser) {
        User saved = userRepository.save(authUser);
        logger.debug("Saved user id {}", saved.getId());
        return saved;
    }
}
