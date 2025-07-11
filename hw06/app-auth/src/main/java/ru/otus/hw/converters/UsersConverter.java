package ru.otus.hw.converters;

import org.springframework.stereotype.Component;
import ru.otus.hw.dto.AuthUserDto;
import ru.otus.hw.models.User;

@Component
public class UsersConverter {
    public User mapDtoToModel(AuthUserDto dto) {
        User authUser = new User();
        authUser.setLogin(dto.getLogin());
        authUser.setPassword(dto.getPassword());
        authUser.setEmail(dto.getEmail());
        authUser.setFirstName(dto.getFirstName());
        authUser.setLastName(dto.getLastName());

        return authUser;
    }
}
