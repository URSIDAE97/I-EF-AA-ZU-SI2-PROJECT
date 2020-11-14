package com.library.govLibrary.controller;

import com.library.govLibrary.controller.dto.UserDto;
import com.library.govLibrary.model.Credentials;
import com.library.govLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${v1USER}")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody Credentials credentials) {
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserDto user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/admin/role/{username}")
    public ResponseEntity<String> addRoleAdmin(@PathVariable String username) {
        return ResponseEntity.ok(userService.addRoleAdmin(username));
    }
}
