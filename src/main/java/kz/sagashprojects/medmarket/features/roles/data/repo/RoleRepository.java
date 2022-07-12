package kz.sagashprojects.medmarket.features.roles.data.repo;

import kz.sagashprojects.medmarket.features.roles.data.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByName(String name);
}
