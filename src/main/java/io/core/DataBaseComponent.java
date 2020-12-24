package io.core;

import io.dao.model.User;
import io.exceptions.EmailAlreadyExistException;
import io.exceptions.UserNotFoundException;
import io.rest.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataBaseComponent {

    public Map<UUID, User> getUsers() {
        return new HashMap<>(users);
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

    public Collection<User> findAllUsersList() {
        if(users.isEmpty()) {
            throw new UserNotFoundException("No one user has been  found");
        }
        return users.values();
    }


    public  User update(UserDto userDto, UUID id) {
        if (!checkEmptyName(userDto)) {
            users.get(id).setName(userDto.getName());
        }
        if (!checkEmptyEmail(userDto)) {
            users.get(id).setEmail(userDto.getEmail());
        }
        if (!checkEmptyAge(userDto)) {
            users.get(id).setAge(userDto.getAge());
        }
        if (!checkEmptyPassword(userDto)) {
            users.get(id).setPassword(userDto.getPassword());
        }
        return getUsers().get(id);
    }

    public User delete(UUID id) {
        return users.remove(id);
    }

    private boolean checkEmptyPassword(UserDto userDto) {
        return userDto.getPassword().isEmpty();
    }

    private boolean checkEmptyAge(UserDto userDto) {
        return userDto.getAge() == 0;
    }

    private boolean checkEmptyEmail(UserDto userDto) {
        return userDto.getEmail().isEmpty();
    }

    private boolean checkEmptyName(UserDto userDto) {
        return userDto.getName().isEmpty();
    }









}
