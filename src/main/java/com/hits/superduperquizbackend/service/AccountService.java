package com.hits.superduperquizbackend.service;

import com.hits.superduperquizbackend.DTO.account.ChangePasswordDTO;
import com.hits.superduperquizbackend.exception.NotFoundException;
import com.hits.superduperquizbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ResponseEntity<?> changePassword(Authentication authentication, ChangePasswordDTO dto) {
        var user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return new ResponseEntity<>(new HashMap<>().put("message", "OK"), HttpStatus.OK);
    }
}
