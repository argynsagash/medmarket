package kz.sagashprojects.medmarket.features.roles.domain.services;

import kz.sagashprojects.medmarket.features.roles.data.entities.RoleEntity;

public interface RoleService {
    RoleEntity saveRole(RoleEntity role);
    void addRoleToUser(String username, String roleName);
}
