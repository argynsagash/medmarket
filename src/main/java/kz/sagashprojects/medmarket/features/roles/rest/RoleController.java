package kz.sagashprojects.medmarket.features.roles.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import kz.sagashprojects.medmarket.features.roles.data.entities.RoleEntity;
import kz.sagashprojects.medmarket.features.roles.domain.services.RoleService;
import kz.sagashprojects.medmarket.features.roles.rest.dto.RoleToUserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/roles")
@Tag(name = "roles", description = "The Roles API")
public class RoleController {
    private final RoleService roleService;


    @PostMapping("/save")
    public ResponseEntity<RoleEntity> saveRole(@RequestBody RoleEntity role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(roleService.saveRole(role));
    }
    @PostMapping("/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        roleService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
