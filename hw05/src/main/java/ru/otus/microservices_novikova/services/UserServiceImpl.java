package ru.otus.microservices_novikova.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.microservices_novikova.entities.User;
import ru.otus.microservices_novikova.repositories.UserRepository;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final Random random = new Random();

    private final double sleepMinTime;

    private final double sleepMaxTime;

    public UserServiceImpl(UserRepository userRepository,
                           @Value("${sleepMinTime}") double sleepMinTime,
                           @Value("${sleepMaxTime}") double sleepMaxTime) {
        this.userRepository = userRepository;
        this.sleepMinTime = sleepMinTime;
        this.sleepMaxTime = sleepMaxTime;
    }

    @Override
    public User findById(long userId) {
        sleep();
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User createUser(User user) {
        sleep();
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        sleep();
        if (userRepository.findById(user.getId()).isPresent()) {
            return userRepository.save(user);
        } else return null;
    }

    @Override
    public void deleteUserById(long id) {
        sleep();
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        sleep();
        return userRepository.findAll();
    }

    private void sleep() {
        try {
            int sleepTime = sleepTime();
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private int sleepTime() {
        return (int) ((random.nextDouble() *
                (sleepMaxTime - sleepMinTime) + sleepMinTime) * 1000);
    }
}
