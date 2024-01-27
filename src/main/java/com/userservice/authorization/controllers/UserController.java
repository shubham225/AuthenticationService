package com.userservice.authorization.controllers;

import com.userservice.authorization.dtos.UserDto;
import com.userservice.authorization.dtos.UserRequestDto;
import com.userservice.authorization.models.User;
import com.userservice.authorization.services.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/V1/users")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}"
    )
    public UserDto getUsers(@PathVariable int id) throws Exception {
        User user = new User();
        user = userService.getUser(id);

        UserDto userDto = new UserDto();

        userDto.setUsername(user.getUsername());
        userDto.setIsActive(user.isActive());

        return userDto;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/signup"
    )
    public UserDto addUser(@RequestBody UserRequestDto user) {
        return userService.addUser(user);
    }
}
