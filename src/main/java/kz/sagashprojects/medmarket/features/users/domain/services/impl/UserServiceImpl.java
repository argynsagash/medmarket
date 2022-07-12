package kz.sagashprojects.medmarket.features.users.domain.services.impl;

import kz.sagashprojects.medmarket.features.roles.data.repo.RoleRepository;
import kz.sagashprojects.medmarket.features.users.data.entities.UserEntity;
import kz.sagashprojects.medmarket.features.users.data.repo.UserRepository;
import kz.sagashprojects.medmarket.features.users.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserEntity> getUser() {
        return userRepository.findAll();
    }
}
