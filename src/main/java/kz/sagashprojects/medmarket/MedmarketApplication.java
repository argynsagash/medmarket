package kz.sagashprojects.medmarket;

import kz.sagashprojects.medmarket.features.roles.data.entities.RoleEntity;
import kz.sagashprojects.medmarket.features.roles.domain.services.RoleService;
import kz.sagashprojects.medmarket.features.users.data.entities.UserEntity;
import kz.sagashprojects.medmarket.features.users.domain.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class MedmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedmarketApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, RoleService roleService) {
        return args -> {
            roleService.saveRole(new RoleEntity(null, "ROLE_USER"));
            roleService.saveRole(new RoleEntity(null, "ROLE_ADMIN"));

            userService.saveUser(new UserEntity(null, "Sagash Argyn", "sagash", " 1234", new ArrayList<>()));
            userService.saveUser(new UserEntity(null, "Ibraim", "ibra", " 1234", new ArrayList<>()));

            roleService.addRoleToUser("sagash", "ROLE_ADMIN");
            roleService.addRoleToUser("ibra", "ROLE_USER");

        };
    }
}
