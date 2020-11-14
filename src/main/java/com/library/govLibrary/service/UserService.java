package com.library.govLibrary.service;

import com.library.govLibrary.controller.dto.UserDto;
import com.library.govLibrary.exception.user.UserAccessForbidden;
import com.library.govLibrary.exception.user.UserAlreadyExistException;
import com.library.govLibrary.exception.user.UserBadRequestException;
import com.library.govLibrary.model.Authorities;
import com.library.govLibrary.model.Users;
import com.library.govLibrary.repository.AuthoritiesRepository;
import com.library.govLibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;

    @Transactional
    public String createUser(UserDto user) {
        try {
            Optional<Users> optionalUser = userRepository.findById(user.getUsername());
            if (optionalUser.isPresent()) throw new UserAlreadyExistException(user.getUsername());

            Users addedUser = new Users();
            addedUser.setUsername(user.getUsername());
            addedUser.setCreated(LocalDateTime.now());
            addedUser.setEmail(user.getEmail());
            addedUser.setEnabled(true);
            addedUser.setName(user.getName());
            addedUser.setSurname(user.getSurname());
            addedUser.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(user.getPassword()));

            userRepository.save(addedUser);

            Authorities authorities = new Authorities();
            authorities.setUsername(user.getUsername());
            authorities.setAuthority("ROLE_ADMIN");
            authoritiesRepository.save(authorities);

            return "User: " + user.getUsername() + " has been created";
        } catch (Exception e) {
            throw new UserBadRequestException(e.getMessage());
        }
    }

    public String addRoleAdmin(String username) {
        Users user = userRepository.findById(username).orElseThrow(() -> new UserBadRequestException("User not found"));
        Authorities authorities = new Authorities();
        authorities.setUsername(user.getUsername());
        authorities.setAuthority("ROLE_ADMIN");
        authoritiesRepository.save(authorities);
        return "Role Admin has been added to user: " + username;
    }

    public void deleteRoleAdmin(String username) {
        Users user = userRepository.findById(username).orElseThrow(() -> new UserBadRequestException("Usern not found"));
        Authorities authorities = new Authorities();
        authorities.setUsername(user.getUsername());
        authorities.setAuthority("ROLE_USER");
        authoritiesRepository.save(authorities);
    }
}
