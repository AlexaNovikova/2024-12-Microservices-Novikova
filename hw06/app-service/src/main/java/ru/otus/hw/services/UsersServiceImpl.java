package ru.otus.hw.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.exceptions.EntityNotFoundException;
import ru.otus.hw.models.User;
import ru.otus.hw.repositories.UsersRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Override
    public Optional<User> findById(String id) {
        var user = usersRepository.findById(Long.valueOf(id));

        if (user.isEmpty()) {
            throw new EntityNotFoundException("One user with ids %s not found".formatted(id));
        }
         return user;
    }

    @Override
    @Transactional
    public User create(String id , String login) {
        User user = new User();
        user.setId(Long.valueOf(id));
        user.setLogin(login);
        logger.debug("User id {}", user.getId());
        System.out.println("User id" + user.getId());
        return usersRepository.save(user);
    }
}
