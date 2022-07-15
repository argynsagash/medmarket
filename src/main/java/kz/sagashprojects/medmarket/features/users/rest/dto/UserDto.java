package kz.sagashprojects.medmarket.features.users.rest.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDto {
    private String name;
    private String username;
    private String password;
}
