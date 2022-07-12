package kz.sagashprojects.medmarket.features.roles.domain.services.impl;

import kz.sagashprojects.medmarket.features.roles.data.entities.RoleEntity;
import kz.sagashprojects.medmarket.features.roles.data.repo.RoleRepository;
import kz.sagashprojects.medmarket.features.roles.domain.services.RoleService;
import kz.sagashprojects.medmarket.features.users.data.entities.UserEntity;
import kz.sagashprojects.medmarket.features.users.data.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    @Override
    public kz.sagashprojects.medmarket.features.roles.data.entities.RoleEntity saveRole(kz.sagashprojects.medmarket.features.roles.data.entities.RoleEntity role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserEntity userEntity = userRepository.findByUsername(username);
        RoleEntity roleEntity = roleRepository.findByName(roleName);
        userEntity.getRoles().add(roleEntity);
    }
}
