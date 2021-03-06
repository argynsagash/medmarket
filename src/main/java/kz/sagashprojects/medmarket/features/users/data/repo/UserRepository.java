package kz.sagashprojects.medmarket.features.users.data.repo;

import kz.sagashprojects.medmarket.features.users.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
