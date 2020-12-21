package io.core;

import io.dao.model.User;
import io.exceptions.UserNotFoundException;
import io.rest.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataBaseComponent {
    public Map<UUID, User> getUsers() {
        return users;
    }

    private final Map<UUID, User> users = new HashMap<>();

    public User createUser(UserDto userDto) {
        UUID id = UUID.randomUUID();
        User user = mapUserDtoToUser(userDto, id);
        users.put(id,user);
        return user;

    }

    private User mapUserDtoToUser(UserDto userDto, UUID id) {
        return new User(id,
                userDto.getName(),
                userDto.getAge(),
                userDto.getEmail(),
                String.valueOf(userDto.getPassword().hashCode()));
    }

    public User findById(UUID id) {

            if (users.get(id) == null) {
                throw new UserNotFoundException("User by id  has been not found");
            }
            return users.get(id);
    }

    public Collection<User> findAllUsers() {
        return users.values();
    }






}
