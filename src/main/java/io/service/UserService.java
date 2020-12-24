package io.service;

import io.dao.UserRepository;
import io.exceptions.*;
import io.rest.dto.UserDto;
import io.dao.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
          throw new EmailNotValidException("Email is not valid");
        }
        else if (checkDuplicateEmail(userDto)) {
            throw new EmailAlreadyExistException("This email is already exist");
        }
        else if (!(userDto.getPassword().length() >= 6)){
            throw new PasswordValidException("Password should be have at least 6 symbols");
        }
        return null;
    }

    public Collection<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
    public Collection<User> findAllUsersList() {
        return userRepository.findAllUsersList();
    }

    public User findUserByEmail(String email) {
        for(Map.Entry<UUID, User> LongUserEntry: userRepository.getUsers().entrySet()){
            if(LongUserEntry.getValue().getEmail().equals(email)){
                return LongUserEntry.getValue();
            }
        }
        throw new NoEmailMatchesException("No email matches found");
    }

    public User findByEmail2(String email) {
       Map<UUID, User> map = userRepository.getUsers();
       return map.values().stream()
               .filter(x -> email.equals(x.getEmail()))
               .findAny().orElse(null);
    }

        public User findUserById (UUID id) {
        return userRepository.findUserById(id);
    }

    public User update(UserDto userDto, UUID id) {
        if (!validate(userDto.getEmail())) {
            throw new EmailNotValidException("Email is not valid");
        } else if (checkDuplicateEmailButNotCurrent(userDto, id)) {
            throw new EmailAlreadyExistException("This email is already exist");
        } else if (!(userDto.getPassword().length() >= 6)) {
            throw new PasswordValidException("Password should be have at least 6 symbols");
        }
        return userRepository.update(userDto,id);
    }

    public User delete(UUID id) {
        if (userRepository.getUsers().get(id) == null) {
            throw new UserNotFoundException("User by id  has been not found");
        }
        userRepository.delete(id);
        throw new DeleteUser("User has been successfully delete");
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

    private boolean checkDuplicateEmailButNotCurrent(UserDto userDto, UUID id) {
        if (userRepository.getUsers().get(id) == null) {
            throw new UserNotFoundException("User by id  has been not found");
        }
        if(!userRepository.getUsers().get(id).getEmail().equals(userDto.getEmail())) {
           return checkDuplicateEmail(userDto);
        }
        return false;
    }

}
