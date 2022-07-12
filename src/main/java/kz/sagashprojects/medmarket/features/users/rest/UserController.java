package kz.sagashprojects.medmarket.features.users.rest;

import kz.sagashprojects.medmarket.features.users.data.entities.UserEntity;
import kz.sagashprojects.medmarket.features.users.domain.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserEntity>> getUsers(){
        return ResponseEntity.ok().body(userService.getUser());
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
}
