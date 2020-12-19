package io.service;

import io.dao.UserRepository;
import io.rest.dto.UserDto;
import io.dao.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserRepository userRepository;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDto userDto) {
        if (!checkDuplicateEmail(userDto) && validate(userDto.getEmail()) && userDto.getPassword().length() >= 6) {
            return userRepository.createUser(userDto);
        }
        else if (!validate(userDto.getEmail())) {
            System.out.println("Email is not valid");
        }
        else if (checkDuplicateEmail(userDto)) {
            System.out.println("This email is already exist");
        }
        else if (!(userDto.getPassword().length() >= 6)){
            System.out.println("Password should be have at least 6 symbols");
        }
        return null;
    }

    public Collection<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public User findUserByEmail(String email) {
        for(Map.Entry<UUID,User> uuidUserEntry: userRepository.getUsers().entrySet()){
            if(uuidUserEntry.getValue().getEmail().equals(email)){
                return uuidUserEntry.getValue();
            }
        }
        System.out.println("No matches found");
        return null;
    }

    public User findUserById(UUID id) {
        return userRepository.findUserById(id);
    }

    private boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private boolean checkDuplicateEmail(UserDto userDto) {
        for (User user : userRepository.findAllUsers()) {
            if (user.getEmail().equals(userDto.getEmail())) {
                return true;
            }
        }
        return false;
    }

}
