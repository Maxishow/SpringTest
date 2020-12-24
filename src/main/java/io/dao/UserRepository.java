package io.dao;

import io.core.DataBaseComponent;
import io.dao.model.User;
import io.rest.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
 private final DataBaseComponent dataBaseComponent;

    public UserRepository(DataBaseComponent dataBaseComponent) {
        this.dataBaseComponent = dataBaseComponent;
    }

    public User createUser(UserDto userDto) {
        return dataBaseComponent.createUser(userDto);
    }

    public User update(UserDto userDto, UUID id) {
        return dataBaseComponent.update(userDto, id);
    }

    public User findUserById(UUID id) {
        return dataBaseComponent.findById(id);
    }

    public Collection<User> findAllUsers() {
        return dataBaseComponent.findAllUsers();
    }

    public Collection<User> findAllUsersList() {
        return dataBaseComponent.findAllUsersList();
    }

    public Map<UUID, User> getUsers() {
        return dataBaseComponent.getUsers();
    }

    public User delete(UUID id) {
        return dataBaseComponent.delete(id);
    }

}
