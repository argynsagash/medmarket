package kz.sagashprojects.medmarket.features.users.rest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import kz.sagashprojects.medmarket.features.roles.data.entities.RoleEntity;
import kz.sagashprojects.medmarket.features.users.data.entities.UserEntity;
import kz.sagashprojects.medmarket.features.users.domain.services.UserService;
import kz.sagashprojects.medmarket.features.users.rest.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@SecurityRequirement(name = "basicauth")
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserEntity>> getUsers(){
        return ResponseEntity.ok().body(userService.getUser());
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserDto user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);
                String username = decodedJWT.getSubject();
                UserEntity userEntity = userService.getUser(username);
                String accessToken = JWT.create()
                        .withSubject(userEntity.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String,String> tokens = new HashMap<>();
                tokens.put("access_token",accessToken);
                tokens.put("refresh_token",refreshToken);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);

            } catch (Exception exception) {

                response.setHeader("error",exception.getMessage());
                response.setStatus(FORBIDDEN.value());
//                    response.sendError(FORBIDDEN.value());
                Map<String,String> error = new HashMap<>();
                error.put("error_message",exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);

            }

        } else {
            throw new RuntimeException("Refresh token is missing");}
    }
}
