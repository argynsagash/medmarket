package kz.sagashprojects.medmarket.features.users.domain.services;


import kz.sagashprojects.medmarket.features.users.data.entities.UserEntity;
import kz.sagashprojects.medmarket.features.users.rest.dto.UserDto;

import java.util.List;

public interface UserService {

    UserEntity saveUser(UserDto userDto);
    UserEntity getUser(String username);
    List<UserEntity> getUser();

}
