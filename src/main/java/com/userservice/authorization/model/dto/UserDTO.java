package com.userservice.authorization.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.userservice.authorization.model.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
public class UserDTO {
    private UUID    id;
    private String  username;
    private String  email;
    private String  mobile;
    private String  address;
    private String  city;
    private String  country;
    private boolean isActive;
    private boolean isAccountLocked;
    private Set<String> roles;
}
