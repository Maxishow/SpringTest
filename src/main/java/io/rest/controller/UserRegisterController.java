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

    @GetMapping("/find-by-id/{id}")
    public User findUserById(@PathVariable("id") UUID id) {
        return userService.findUserById(id);

    }

    @GetMapping("/find-by-email/{email}")
    public User findByEmail(@PathVariable("email") String email ) {
        return userService.findUserByEmail(email);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable UUID id, @RequestBody UserDto userDto) {
        return userService.update(userDto,id);
    }

}
