package io.rest.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.dao.model.User;
import io.rest.dto.UserDto;
import io.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserRegisterController {
    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody UserDto userDto) {
       return  userService.createUser(userDto);
    }

    @PostMapping("/find-all")
    public List<String> findAllUsers() {
        return userService.findAllUsers().stream()
                .map(User::toString)
                .collect(Collectors.toList());
    }

    @PostMapping("/find-by-id")
    public User findUserById(@RequestBody UUID id) {
        return userService.findUserById(id);

    }

    @PostMapping("/find-by-email")
    public User findByEmail(@RequestBody String email ) {
        return userService.findUserByEmail(email);
    }

    /**
     * Написать контроллер поиск юзера по айдишнику
     * Нельзя создавать юзера с одинаковым емеилом
     * Написать контроллер поиск юзера по емеилу
     * Добавить валидация пароля как минимум 6 символов
     * Переписать валидацию, на исключения
     * Правильные ответы
     */

}
