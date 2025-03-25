package ru.otus.microservices_novikova.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.microservices_novikova.entities.User;
import ru.otus.microservices_novikova.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findById(long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            return userRepository.save(user);
        } else return null;
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
