package com.userservice.authorization.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String  username;
    private String  password;
}
