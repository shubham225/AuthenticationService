package com.authenticator.user.services;

import com.authenticator.user.dtos.ExceptionDto;
import com.authenticator.user.dtos.UserDto;
import com.authenticator.user.dtos.UserRequestDto;
import com.authenticator.user.exceptions.NotFoundException;
import com.authenticator.user.models.User;
import com.authenticator.user.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    public User getUser(int id) throws Exception {
        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isEmpty())
            throw new NotFoundException("User " + id + " do not exists");

        return userOptional.get();
    }

    public UserDto addUser(UserRequestDto user) {
        User userNew = new User();
        userNew.setUsername(user.getUsername());
        userNew.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userNew.setActive(false);

        userRepository.save(userNew);

        UserDto userDto = new UserDto();
        userDto.setUsername(userNew.getUsername());
        userDto.setIsActive(false);

        return userDto;
    }
}
