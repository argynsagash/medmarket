package kz.sagashprojects.medmarket.features.users.domain.services.impl;

import kz.sagashprojects.medmarket.features.users.data.entities.UserEntity;
import kz.sagashprojects.medmarket.features.users.data.repo.UserRepository;
import kz.sagashprojects.medmarket.features.users.domain.services.UserService;
import kz.sagashprojects.medmarket.features.users.rest.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) throw new UsernameNotFoundException("User not found in the database");
        Collection<SimpleGrantedAuthority> auth = new ArrayList<>();
        userEntity.getRoles().forEach(role->{
            auth.add(new SimpleGrantedAuthority(role.getName()));
        });
        //return user from spring with info taken from our userentity
        return new User(userEntity.getUsername(),userEntity.getPassword(),auth);
    }

    @Override
    public UserEntity saveUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
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
