package kz.sagashprojects.medmarket.features.users.data.entities;

import kz.sagashprojects.medmarket.features.roles.data.entities.RoleEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "app_user")
public class UserEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String username;
    @Column
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleEntity> roles = new ArrayList<>();
}
