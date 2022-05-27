package com.hits.superduperquizbackend.controller;

import com.hits.superduperquizbackend.DTO.AuthenticationDTO;
import com.hits.superduperquizbackend.DTO.RegisterDTO;
import com.hits.superduperquizbackend.DTO.category.CategoryDTO;
import com.hits.superduperquizbackend.entity.UserEntity;
import com.hits.superduperquizbackend.exception.BadRequestException;
import com.hits.superduperquizbackend.repository.UserRepository;
import com.hits.superduperquizbackend.security.JWTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JWTokenProvider jwTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationDTO dto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
            UserEntity user = userRepository.findByUsername(dto.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));
            String token = jwTokenProvider.createToken(dto.getEmail(), user.getRole());
            Map<Object, Object> response = new HashMap<>();
            response.put("username", dto.getEmail());
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid email or/and password", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO dto) {
        var userWithTheSameUsername = userRepository.findByUsername(dto.getUsername());
        if (userWithTheSameUsername.isPresent()) {
            return new ResponseEntity<>(new HashMap<>().put("message", "User with the same username already exists"), HttpStatus.BAD_REQUEST);
        }
        var user = new UserEntity(dto.getUsername(), passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>(new HashMap<>().put("message", "OK"), HttpStatus.OK);
    }
}
