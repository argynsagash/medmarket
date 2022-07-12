package kz.sagashprojects.medmarket.features.users.domain.services;


import kz.sagashprojects.medmarket.features.users.data.entities.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity saveUser(UserEntity userEntity);
    UserEntity getUser(String username);
    List<UserEntity> getUser();

}
